package edu.uno.eventmanager;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class EventDatabase {

    // Database fields
    private SQLiteDatabase database;
    private EventDatabaseHelper dbHelper;
    private String[] allColumns = { EventDatabaseHelper.COLUMN_ID,
            EventDatabaseHelper.COLUMN_TITLE,
            EventDatabaseHelper.COLUMN_DESC,
            EventDatabaseHelper.COLUMN_DATE,
            EventDatabaseHelper.COLUMN_TIME };

    public EventDatabase(Context context) {
        dbHelper = new EventDatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() throws SQLException {
        dbHelper.close();
    }



    public void createEvent(String title, String desc, String date, String time) {
        ContentValues values = new ContentValues();
        values.put(EventDatabaseHelper.COLUMN_TITLE, title);
        values.put(EventDatabaseHelper.COLUMN_DESC, desc);
        values.put(EventDatabaseHelper.COLUMN_DATE, date);
        values.put(EventDatabaseHelper.COLUMN_TIME, time);
        database.insert(dbHelper.EVENTS_TABLE, null, values);

    }

    public void deleteEvent(Event event) {
        long id = event.getId();
        System.out.println("Event deleted with id: " + id);
        database.delete(EventDatabaseHelper.EVENTS_TABLE, EventDatabaseHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<Event>();

        Cursor cursor = database.query(EventDatabaseHelper.EVENTS_TABLE,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Event event = cursorToEvent(cursor);
            events.add(event);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return events;
    }

    //returns events where the value in the specified column = the specified value
    public List<Event> getSomeEvents(String column,String value){
        List<Event> events = new ArrayList<Event>();
        Cursor cursor = database.query(EventDatabaseHelper.EVENTS_TABLE, allColumns, column + " = '"+value+"'", null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Event event = cursorToEvent(cursor);
            events.add(event);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return events;

    }

    public void updateEvent(long id, String title, String desc, String date, String time) {
        ContentValues args = new ContentValues();
        args.put(EventDatabaseHelper.COLUMN_TITLE, title);
        args.put(EventDatabaseHelper.COLUMN_DESC, desc);
        args.put(EventDatabaseHelper.COLUMN_DATE, date);
        args.put(EventDatabaseHelper.COLUMN_TIME, time);
        database.update(EventDatabaseHelper.EVENTS_TABLE, args,
                EventDatabaseHelper.COLUMN_ID + "=" + id, null);
    }

    private Event cursorToEvent(Cursor cursor) {
        Event event = new Event(0, null, null, null, null);
        event.setId(cursor.getLong(0));
        event.setTitle(cursor.getString(1));
        event.setDescription(cursor.getString(2));
        event.setDate(cursor.getString(3));
        event.setTime(cursor.getString(4));
        return event;
    }
}
