package edu.uno.eventmanager;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class EditingModeActivity extends Activity {

    EditText banner, title, desc, date, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editing_mode);
    }

    }
