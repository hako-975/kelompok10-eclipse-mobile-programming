package com.example.ontouch;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color; 
import android.view.Menu;

public class MainActivity extends Activity {

	TempatGambar tempatGambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempatGambar = new TempatGambar(this);
        tempatGambar.setBackgroundColor(Color.WHITE);
        setContentView(tempatGambar);
        tempatGambar.requestFocus();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
