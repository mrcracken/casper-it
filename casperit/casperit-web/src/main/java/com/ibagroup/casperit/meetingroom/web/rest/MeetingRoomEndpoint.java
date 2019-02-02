package com.ibagroup.casperit.meetingroom.web.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ibagroup.casperit.meetingroom.database.dao.MeetingRoomSearchParams;
import com.ibagroup.casperit.meetingroom.database.dto.MeetingRoom;
import com.ibagroup.casperit.meetingroom.service.MeetingRoomService;

/**
 * JAX-RS CRUD for {@link MeetingRoom}
 * <p/>
 * This class produces a RESTful service to read/write the contents of the members table.
 */
@Path("/meetingrooms")
@RequestScoped
public class MeetingRoomEndpoint {

	@Inject
    private MeetingRoomService service;

	/*
	 * Return all MeetingRoom
	 */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MeetingRoom> retrieveAllMeetingRoom() {
    	MeetingRoomSearchParams params = new MeetingRoomSearchParams();
        return service.retrieveMeetingRoom(params);
    }
	
}

