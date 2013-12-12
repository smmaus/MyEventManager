package edu.uno.eventmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class EventDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "EventProvider";

    private static final String DATABASE_NAME = "events.db";
    private static final int DATABASE_VERSION = 1;
    public static final String EVENTS_TABLE = "events";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESC = "description";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_TIME = "time";

    // Database creation SQL statement
    private static final String DATABASE_CREATE =
            "create table " + EVENTS_TABLE + "("
                    + COLUMN_ID + " integer primary key autoincrement, "
                    + COLUMN_TITLE + " TEXT, "
                    + COLUMN_DESC + " TEXT, "
                    + COLUMN_DATE + " TEXT, "
                    + COLUMN_TIME + " TEXT);";

    public EventDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + EVENTS_TABLE);
        onCreate(db);
    }

}
