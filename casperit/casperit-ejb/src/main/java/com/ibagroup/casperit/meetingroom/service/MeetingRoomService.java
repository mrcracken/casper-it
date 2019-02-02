package com.ibagroup.casperit.meetingroom.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.ibagroup.casperit.meetingroom.database.dao.MeetingRoomDaoImpl;
import com.ibagroup.casperit.meetingroom.database.dao.MeetingRoomSearchParams;
import com.ibagroup.casperit.meetingroom.database.dto.MeetingRoom;

/**
 * 
 * @author IBA Group
 * @since 2019
 *
 */
@Stateless
public class MeetingRoomService {
	
	@Inject
	MeetingRoomDaoImpl dao;
    
	public List<MeetingRoom> retrieveMeetingRoom(MeetingRoomSearchParams params) {
	    	return dao.retrieveMeetingRoomByParams(params);
	    }
	
}
