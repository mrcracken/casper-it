package com.ibagroup.casperit.meetingroom.database.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ibagroup.casperit.meetingroom.database.dto.MeetingRoom;

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
public class MeetingRoomDaoImpl implements Serializable {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	/**
	* <p> Return all MeetingRoomReservation if other parameters are null </p>
	* @param search parameters
	* @return list of MeetingRoom
	*/
	public List<MeetingRoom> retrieveMeetingRoomByParams(MeetingRoomSearchParams params) throws NonUniqueResultException {
			TypedQuery<MeetingRoom> query = em.createQuery("SELECT DISTINCT m FROM MeetingRoom m ORDER BY m.id", MeetingRoom.class);
			try {
				return (List<MeetingRoom>) query.getResultList();
			} catch (NoResultException exc) {
				return null;
			}
	}

}
