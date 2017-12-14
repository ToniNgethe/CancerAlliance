package app.feed.mercyapp.models.responses;

/**
 * Created by toni on 12/14/17.
 */

public class EventResponse {
    private String message;
    private String error;
    private String data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
