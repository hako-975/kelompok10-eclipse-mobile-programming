package com.example.rahmatprasetyoontouch;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.graphics.Color;

public class RahmatPrasetyoOnTouch extends Activity {
	RahmatPrasetyoTempatGambar tempatGambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rahmat_prasetyo_on_touch);

        tempatGambar = new RahmatPrasetyoTempatGambar(this);
        tempatGambar.setBackgroundColor(Color.WHITE);
        setContentView(tempatGambar);
        tempatGambar.requestFocus();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_rahmat_prasetyo_on_touch, menu);
        return true;
    }
}