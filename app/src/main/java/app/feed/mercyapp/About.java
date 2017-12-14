package app.feed.mercyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbarAbout = findViewById(R.id.toolbarAbout);
        setSupportActionBar(toolbarAbout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");
    }
}
