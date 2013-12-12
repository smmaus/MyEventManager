package edu.uno.eventmanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

/**
 * Created by SUZEE on 11/6/13.
 */

public class SearchActivity extends Activity {

    EditText searchEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        //"Search Event"
        searchEvent = (EditText) findViewById(R.id.searchEvents);
    }

    //Change this later to suite add_activity, pasted from mainActivity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
