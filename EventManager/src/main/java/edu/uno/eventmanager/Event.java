package edu.uno.eventmanager;

/**
 * Created by SUZEE on 12/7/13.
 */

public class Event {

    private long id;
    private String title, desc, date, time;

    public Event(long id, String title, String desc, String date, String time) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long _id) {
        id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String _title) {
        title = _title;
    }

    public String getDescription() {
        return desc;
    }

    public void setDescription(String _desc) {
        desc = _desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String _date) {
        date = _date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String _time) {
        time = _time;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return title + "(" + id + ")\n"
                + desc + "\n"
                + "Date: " + date + "\n"
                + "Time: " + time;
    }

}
