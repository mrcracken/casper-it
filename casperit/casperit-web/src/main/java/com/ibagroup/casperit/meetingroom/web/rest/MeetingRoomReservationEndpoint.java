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

import com.ibagroup.casperit.meetingroom.database.dao.MeetingRoomReservationSearchParams;
import com.ibagroup.casperit.meetingroom.database.dto.MeetingRoomReservation;
import com.ibagroup.casperit.meetingroom.service.MeetingRoomReservationService;

/**
 * JAX-RS CRUD for {@link MeetingRoomReservation}
 * <p/>
 * This class produces a RESTful service to read/write the contents of the members table.
 */
@Path("/reservation")
@RequestScoped
public class MeetingRoomReservationEndpoint {

	@Inject
    private MeetingRoomReservationService service;

	/*
	 * Return all MeetingRoomReservations
	 */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MeetingRoomReservation> retrieveAllMeetingRoomReservations() {
    	MeetingRoomReservationSearchParams params = new MeetingRoomReservationSearchParams();
        return service.retrieveMeetingRoomReservation(params);
    }
    
    /*
	 * Return MeetingRoomReservation by time
	 */
    @GET
    @Path("/date/{currentDate:[0-9][0-9]*}")
    @Produces("application/json")
    public List<MeetingRoomReservation> retrieveMeetingRoomReservationsByTime(@PathParam("currentDate") Long currentDate) {
        return service.retrieveMeetingRoomReservationByTime(currentDate);
    }
    
    /*
	 * Return MeetingRoomReservation by ID
	 */
    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("application/json")
    public List<MeetingRoomReservation> retrieveMeetingRoomReservationsById(@PathParam("id") Long id) {
    	MeetingRoomReservationSearchParams params = new MeetingRoomReservationSearchParams();
    	params.setId(id);
        return service.retrieveMeetingRoomReservation(params);
    }

    /*
	 * Delete MeetingRoomReservation by ID
	 */
    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public void deleteMeetingRoomReservationsById(@PathParam("id") Long id) {
    	service.deleteMeetingRoomReservationById(id);
    }
    
    /*
	 * Create a new MeetingRoomReservation
	 */
    @POST
    @Consumes("application/json")
    public void createNewMeetingRoomReservation(MeetingRoomReservation entity) throws Exception {
    	service.createNewMeetingRoomReservation(entity);
    }
	
}
