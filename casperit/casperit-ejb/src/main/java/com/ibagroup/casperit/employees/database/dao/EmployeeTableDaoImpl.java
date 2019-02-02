package com.ibagroup.casperit.employees.database.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ibagroup.casperit.employees.database.dto.EmployeeTable;

//Use @RequestScoped
//https://stackoverflow.com/questions/27149388/no-bean-is-eligible-for-injection-to-the-injection-point

/*
* We suppress the warning about not specifying a serialVersionUID, as we are still developing this app, and want the JVM to
* generate the serialVersionUID for us. When we put this app into production, we'll generate and embed the serialVersionUID
*/
@SuppressWarnings("serial")
@RequestScoped
public class EmployeeTableDaoImpl implements Serializable {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private Event<EmployeeTable> EmployeeTableEventSrc;
	
	/**
	* <p> Return all EmployeeTable if other parameters are null </p>
	* @param search parameters
	* @return list of EmployeeTable
	*/
	public List<EmployeeTable> retrieveEmployeeTableByParams(EmployeeTableSearchParams params) throws NonUniqueResultException {
		if (params.getId() != null || params.getFirstName() != null || params.getLastName() != null || params.getPhone() != null || params.getSpecialization() != null || params.getFloor() != null || params.getPhone() !=null || params.getSpace() != null || params.getCode() != null || params.getAddress() != null) {
			TypedQuery<EmployeeTable> query = em.createQuery("SELECT e FROM EmployeeTable e WHERE e.id = :id OR e.employee.firstName = :firstName OR e.employee.lastName = :lastName OR e.employee.specialization = :specialization OR e.employee.phone = :phone OR e.code = :code OR e.floor = :floor OR e.space = :space OR e.address = :address ORDER BY e.code", EmployeeTable.class);
		  	  	if (params.getId() != null)
			  			query.setParameter("id", params.getId());
			  		else query.setParameter("id", null);
				if (params.getFirstName() != null)
						query.setParameter("firstName", params.getFirstName());
					else query.setParameter("firstName", null);
				if (params.getLastName() != null)
						query.setParameter("lastName", params.getLastName());
					else  query.setParameter("lastName", null);
				if (params.getPhone() != null)
						query.setParameter("phone", params.getPhone());
					else query.setParameter("phone", null);
				if (params.getSpecialization() != null)
						query.setParameter("specialization", params.getSpecialization());
					else query.setParameter("specialization", null);
				if (params.getCode() != null)
						query.setParameter("code", params.getCode());
					else query.setParameter("code", null);
				if (params.getFloor() != null)
						query.setParameter("floor", params.getFloor());
					else query.setParameter("floor", null);
				if (params.getSpace() != null)
						query.setParameter("space", params.getSpace());
					else query.setParameter("space", null);
				if (params.getAddress() != null)
						query.setParameter("address", params.getAddress());
					else query.setParameter("address", null);
				try {
					return (List<EmployeeTable>) query.getResultList();
				} catch (NoResultException exc) {
					return null;
				}
		} else {
			TypedQuery<EmployeeTable> query = em.createQuery("SELECT DISTINCT e FROM EmployeeTable e ORDER BY e.code", EmployeeTable.class);
			try {
				return (List<EmployeeTable>) query.getResultList();
			} catch (NoResultException exc) {
				return null;
			}
		}
	}
	
	/**
	* <p> Return all EmployeeTable if other parameters are null </p>
	* @param search parameters
	* @return list of EmployeeTable
	*/
	public List<EmployeeTable> retrieveEmployeeTableByFSAParams(EmployeeTableSearchParams params) throws NonUniqueResultException {
			TypedQuery<EmployeeTable> query = em.createQuery("SELECT e FROM EmployeeTable e WHERE e.floor = :floor AND e.space = :space AND e.address = :address ORDER BY e.code", EmployeeTable.class);
				if (params.getFloor() != null)
						query.setParameter("floor", params.getFloor());
					else query.setParameter("floor", null);
				if (params.getSpace() != null)
						query.setParameter("space", params.getSpace());
					else query.setParameter("space", null);
				if (params.getAddress() != null)
						query.setParameter("address", params.getAddress());
					else query.setParameter("address", null);
				try {
					return (List<EmployeeTable>) query.getResultList();
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
	
	public void createNewEmployeeTable(EmployeeTable entity) throws Exception {
	  em.persist(entity);
	  EmployeeTableEventSrc.fire(entity);
	}
	
	//public Response update(Long id, EmployeeTableDto dto) {
	//    TypedQuery<EmployeeTable> findByIdQuery = em.createQuery("SELECT DISTINCT c FROM EmployeeTable c WHERE c.id = :entityId ORDER BY c.id", EmployeeTable.class);
	//    findByIdQuery.setParameter("entityId", id);
	//    EmployeeTable entity;
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
	
	public void deleteEmployeeTableById(Long id) {
		  EmployeeTable entity = em.find(EmployeeTable.class, id);
	    if (entity == null) {
	       entity = new EmployeeTable();
	    }
	    em.remove(entity);
	 }

}
