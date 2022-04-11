package model;

public class Event {

	private String eventUserId;
	private double value;
	private String description;
	private Date eventDate;
	private EventType type;
	
	//getters
	public Date getEventDate() {
		return this.eventDate;
	}
	public EventType getType() {
		return this.type;
	}
	public String getEventUserId() {
		return this.eventUserId;
	}
	public double getValue() {
		return this.value;
	}
	public String getDescription() {
		return this.description;
	}
	//setters
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public void setType(EventType type) {
		this.type = type;
	}
	public void setEventUserId(String eventUserId) {
		this.eventUserId = eventUserId;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * This is the constructor of an Event class
	 * @param eventUserId String, has the name of the host of the event
	 * @param value double, has the value of the event to be carried out
	 * @param description String, has a description of the event
	 * @param eventDate Date, It has the day, month and year in which the event will take place
	 * @param type EventType, indicates the type of event to be held, these being maintenance, school visits, improvement activity, and celebration
	 */
	public Event(String eventUserId, double value, String description, Date eventDate,EventType type) {
		this.eventUserId=eventUserId;
		this.value=value;
		this.description=description;
		this.eventDate=eventDate;
		this.type=type;
	}
}