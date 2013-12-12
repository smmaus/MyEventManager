package edu.uno.eventmanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddEventActivity extends Activity{

    EditText banner, title, desc, date, time;
    Context context = this.getApplicationContext();
    EventDatabase db = new EventDatabase(context);
    private boolean alarm = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        //"ADD EVENT"
        banner = (EditText) findViewById(R.id.addEvent);

        //Variables <title, desc, date, time>
        title = (EditText) findViewById(R.id.addEventTitle);
        desc = (EditText) findViewById(R.id.addEventDesc);
        date = (EditText) findViewById(R.id.addEventDate);
        time = (EditText) findViewById(R.id.addEventTime);

        //Adds the event to the database, then takes you back to the MainActivity
        final Button addEventButton = (Button) findViewById(R.id.addButton2);
        addEventButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addEvent(title.getText().toString(),
                        desc.getText().toString(),
                        date.getText().toString(),
                        time.getText().toString());
                Toast.makeText(getApplicationContext(), "Event added!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AddEventActivity.this,MainActivity.class));
            }
        });

    }


    public void addEvent(String title, String dsc, String dte, String tme) {
        db.open();
        db.createEvent(title, dsc, dte,tme);
        db.close();
    }

    //Change this later to suit add_activity, pasted from mainActivity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
