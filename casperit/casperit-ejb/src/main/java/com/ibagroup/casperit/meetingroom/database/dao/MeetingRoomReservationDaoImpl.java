package com.ibagroup.casperit.meetingroom.database.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ibagroup.casperit.meetingroom.database.dto.MeetingRoomReservation;

/**
 * 
 * @author IBA Group
 * @since 2019
 *
 */

//Use @RequestScoped
//https://stackoverflow.com/questions/27149388/no-bean-is-eligible-for-injection-to-the-injection-point

/*
* We suppress the warning about not specifying a serialVersionUID, as we are still developing this app, and want the JVM to
* generate the serialVersionUID for us. When we put this app into production, we'll generate and embed the serialVersionUID
*/
@SuppressWarnings("serial")
@RequestScoped
public class MeetingRoomReservationDaoImpl implements Serializable {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private Event<MeetingRoomReservation> MeetingRoomReservationEventSrc;
	
	private Date date = new Date();
	
	/**
	* <p> Return all MeetingRoomReservation if other parameters are null </p>
	* @param search parameters
	* @return list of MeetingRoomReservation
	*/
	public List<MeetingRoomReservation> retrieveMeetingRoomReservationByParams(MeetingRoomReservationSearchParams params) throws NonUniqueResultException {
		if (params.getId() != null || params.getComplectation() != null || params.getEndDate() != null || params.getStartDate() != null || params.getName() != null || params.getFloor() != null || params.getFirstName() != null || params.getLastName() != null || params.getCapacity() != null) {
			TypedQuery<MeetingRoomReservation> query = em.createQuery("SELECT m FROM MeetingRoomReservation m WHERE m.id = :id OR m.employee.firstName = :firstName OR m.employee.lastName = :lastName OR m.meetingRoom.capacity = :capacity OR m.meetingRoom.name = :name OR m.meetingRoom.floor = :floor OR m.meetingRoom.complectation = :complectation OR m.startDate = :startDate OR m.endDate = :endDate ", MeetingRoomReservation.class);
		  	  	if (params.getId() != null)
			  			query.setParameter("id", params.getId());
			  		else query.setParameter("id", null);
				if (params.getFirstName() != null)
						query.setParameter("firstName", params.getFirstName());
					else query.setParameter("firstName", null);
				if (params.getLastName() != null)
						query.setParameter("lastName", params.getLastName());
					else  query.setParameter("lastName", null);
				if (params.getCapacity() != null)
						query.setParameter("capacity", params.getCapacity());
					else query.setParameter("capacity", null);
				if (params.getComplectation() != null)
						query.setParameter("complectation", params.getComplectation());
					else query.setParameter("complectation", null);
				if (params.getEndDate() != null)
						query.setParameter("endDate", params.getEndDate());
					else query.setParameter("endDate", null);
				if (params.getStartDate() != null)
						query.setParameter("startDate", params.getStartDate());
					else query.setParameter("startDate", null);
				if (params.getName() != null)
						query.setParameter("name", params.getName());
					else query.setParameter("name", null);
				if (params.getFloor() != null)
						query.setParameter("floor", params.getFloor());
					else query.setParameter("floor", null);
				try {
					return (List<MeetingRoomReservation>) query.getResultList();
				} catch (NoResultException exc) {
					return null;
				}
		} else {
			TypedQuery<MeetingRoomReservation> query = em.createQuery("SELECT DISTINCT m FROM MeetingRoomReservation m ORDER BY m.id", MeetingRoomReservation.class);
			try {
				return (List<MeetingRoomReservation>) query.getResultList();
			} catch (NoResultException exc) {
				return null;
			}
		}
	}
	
//	x - system
//	s - start time
//	e - end time
//
//	where (x-1<s and s<x+1) and (e>= x)
	
	public List<MeetingRoomReservation> retrieveMeetingRoomReservationByTimeParams(Long currentDate) throws NonUniqueResultException {       
		String sql = "SELECT * FROM meetingroomreservation WHERE ((startDate - 100) < " + currentDate + " AND (startDate + 100) > " + currentDate + ") AND endDate >= " + currentDate;
		TypedQuery<MeetingRoomReservation> query = em.createQuery("SELECT m FROM MeetingRoomReservation m WHERE ((m.startDate - 100) < :currentDate AND (m.startDate + 100) > :currentDate) AND m.endDate >= :currentDate", MeetingRoomReservation.class);
//		TypedQuery<MeetingRoomReservation> query = em.createQuery(sql, MeetingRoomReservation.class);  	
//		TypedQuery<MeetingRoomReservation> query = em.createQuery("SELECT DISTINCT m FROM MeetingRoomReservation m ORDER BY m.id", MeetingRoomReservation.class);
		query.setParameter("currentDate", currentDate);
		try {
			return (List<MeetingRoomReservation>) query.getResultList();
		} catch (NoResultException exc) {
			return null;
		}
	}
	
	//Some code example	
	//
	//public Order findOrderSubmittedAt(Date date) throws NonUniqueResultException {
	//	Query q = entityManager.createQuery(
	//		"SELECT e FROM " + entityClass.getName() + " e WHERE date = :date_at");
	//	q.setParameter("date_at", date);
	//	try {
	//		return (Order) q.getSingleResult();
	//	} catch (NoResultException exc) {
	//		return null;
	//	}
	//}
	//
	//public Order getOrderSubmittedAt(Date date) throws NoResultException, NonUniqueResultException {
	//	Query q = entityManager.createQuery(
	//		"SELECT e FROM " + entityClass.getName() + " e WHERE date = :date_at");
	//	q.setParameter("date_at", date);
	//	return (Order) q.getSingleResult();
	//}
	//
	//
	//https://xebia.com/blog/jpa-implementation-patterns-data-access-objects/#JpaDao
	//
	//public class JpaOrderDao extends JpaDao<Integer, Order> implements OrderDao {
	//	public List<Order> findOrdersSubmittedSince(Date date) {
	//		Query q = entityManager.createQuery(
	//			"SELECT e FROM " + entityClass.getName() + " e WHERE date >= :date_since");
	//		q.setParameter("date_since", date);
	//		return (List<Order>) q.getResultList();
	//	}
	//}
	//
	
	public void createNewMeetingRoomReservation(MeetingRoomReservation entity) throws Exception {
	  em.persist(entity);
	  MeetingRoomReservationEventSrc.fire(entity);
	}
	
	//public Response update(Long id, MeetingRoomReservationDto dto) {
	//    TypedQuery<MeetingRoomReservation> findByIdQuery = em.createQuery("SELECT DISTINCT c FROM MeetingRoomReservation c WHERE c.id = :entityId ORDER BY c.id", MeetingRoomReservation.class);
	//    findByIdQuery.setParameter("entityId", id);
	//    MeetingRoomReservation entity;
	//    try {
	//       entity = findByIdQuery.getSingleResult();
	//    }
	//    catch (NoResultException nre) {
	//       entity = null;
	//    }
	//    entity = dto.fromDto(entity, em);
	//    try {
	//       entity = em.merge(entity);
	//    }
	//    catch (OptimisticLockException e) {
	//       return Response.status(Response.Status.CONFLICT).entity(e.getEntity()).build();
	//    }
	//    return Response.noContent().build();
	// }
	
	public void deleteMeetingRoomReservationById(Long id) {
		MeetingRoomReservation entity = em.find(MeetingRoomReservation.class, id);
	    if (entity == null) {
	       entity = new MeetingRoomReservation();
	    }
	    em.remove(entity);
	 }

}
