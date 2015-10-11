package com.arizona.milkmoney;

import java.io.Serializable;

public class EventDetailPOJO implements Serializable {
	//eventId,programId,Date,Time,VolunteerCount,Description,ProgramName
	String eventId ="";
	String address = "";
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTotalVolunteerNeeded() {
		return totalVolunteerNeeded;
	}
	public void setTotalVolunteerNeeded(int totalVolunteerNeeded) {
		this.totalVolunteerNeeded = totalVolunteerNeeded;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getProgramId() {
		return programId;
	}
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getVolunteerCount() {
		return volunteerCount;
	}
	public void setVolunteerCount(int volunteerCount) {
		this.volunteerCount = volunteerCount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	String programId ="" ;
	String eventName="";
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	String date = "";
	String time = "";
	int volunteerCount=0;
	int totalVolunteerNeeded=0;
	String description="";
	String programName = "";
	String imageUrl = "";
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	

}
