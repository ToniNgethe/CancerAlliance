package app.feed.mercyapp.models.responses;

import java.io.Serializable;

/**
 * Created by Mercy.Ikami on 12/2/2017.
 */

public class FeedResponse implements Serializable{
    private int Id;
    private String Tittle;
    private String Feed;
    private String Date;
    private String Image;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String Tittle) {
        this.Tittle = Tittle;
    }

    public String getFeed() {
        return Feed;
    }

    public void setFeed(String Feed) {
        this.Feed = Feed;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }
}
