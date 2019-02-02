package com.ibagroup.casperit.meetingroom.database.dao;

import java.sql.Date;

public class MeetingRoomSearchParams {

	private Date startDate;
	
	private Date endDate;

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
