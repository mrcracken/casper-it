package com.ibagroup.casperit.meetingroom.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.ibagroup.casperit.meetingroom.database.dao.MeetingRoomReservationDaoImpl;
import com.ibagroup.casperit.meetingroom.database.dao.MeetingRoomReservationSearchParams;
import com.ibagroup.casperit.meetingroom.database.dto.MeetingRoomReservation;

/**
 * 
 * @author IBA Group
 * @since 2019
 *
 */

@Stateless
public class MeetingRoomReservationService {
	
	@Inject
	MeetingRoomReservationDaoImpl dao;
    
	public List<MeetingRoomReservation> retrieveMeetingRoomReservation(MeetingRoomReservationSearchParams params) {
	    	return dao.retrieveMeetingRoomReservationByParams(params);
	}
 
    public void deleteMeetingRoomReservationById(Long id) {
    	dao.deleteMeetingRoomReservationById(id);;
    }
    
    public void createNewMeetingRoomReservation(MeetingRoomReservation entity) throws Exception {
    	dao.createNewMeetingRoomReservation(entity);;
    }
    
    public List<MeetingRoomReservation> retrieveMeetingRoomReservationByTime(Long currentDate) {
    	return dao.retrieveMeetingRoomReservationByTimeParams(currentDate);
    }
	
//    @PUT
//    @Path("/{id:[0-9][0-9]*}")
//    @Consumes("application/json")
//    public void update(@PathParam("id") Long id, MeetingRoomReservation entity) {
//    	dao.update(id, entity);
//    }

}
