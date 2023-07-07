package com.example.aldohermawansuryanaontouch;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;

public class AldoHermawanSuryanaOnTouch extends Activity {
	TempatGambar tempatGambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aldo_hermawan_suryana_on_touch);

        tempatGambar = new TempatGambar(this);
        tempatGambar.setBackgroundColor(Color.WHITE);
        setContentView(tempatGambar);
        tempatGambar.requestFocus();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_aldo_hermawan_suryana_on_touch, menu);
        return true;
    }
}
