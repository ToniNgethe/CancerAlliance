package app.feed.mercyapp.models.responses;

/**
 * Created by toni on 12/14/17.
 */

public class EventsListResponse {
    private int Id;
    private String eventTittle;
    private String eventImage;
    private String eventVenue;
    private String eventTime;
    private String eventDescription;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getEventTittle() {
        return eventTittle;
    }

    public void setEventTittle(String eventTittle) {
        this.eventTittle = eventTittle;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
}
