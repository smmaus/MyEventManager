package edu.uno.eventmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ManageActivity extends Activity {

    EditText manageEvent;
    ListView eventListView;
    Context context = this.getApplicationContext();
    EventDatabase db = new EventDatabase(context);
    List<Event> events = new ArrayList<Event>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_activity);

        //"Manage Events"
        manageEvent = (EditText) findViewById(R.id.manageEvents);

        events = db.getAllEvents();
        eventListView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<Event> adapter = new EventListAdapter();
        eventListView.setAdapter(adapter);

        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(ManageActivity.this,EditingModeActivity.class));
            }
        });
    }

    private class EventListAdapter extends ArrayAdapter<Event> {
        private EventListAdapter() {
            super(ManageActivity.this, R.layout.listview_main, events);
        }

        @Override
        public View getView(int pos, View view, ViewGroup parent) {
            View itemView = view;
            if(view==null)
                itemView = getLayoutInflater().inflate(R.layout.listview_main, parent, false);
            Event currentEvent = events.get(pos);

            TextView title = (TextView) itemView.findViewById(R.id.textTitle);
            title.setText(currentEvent.getTitle());
            TextView desc = (TextView) itemView.findViewById(R.id.textDesc);
            desc.setText(currentEvent.getDescription());
            TextView date = (TextView) itemView.findViewById(R.id.textDate);
            desc.setText(currentEvent.getDate());
            TextView time = (TextView) itemView.findViewById(R.id.textTime);
            desc.setText(currentEvent.getTime());

            return itemView;
        }
    }

    //Change this later to suite add_activity, pasted from mainActivity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
