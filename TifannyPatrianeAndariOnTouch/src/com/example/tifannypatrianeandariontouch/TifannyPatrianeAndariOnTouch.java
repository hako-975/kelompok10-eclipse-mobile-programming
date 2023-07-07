package com.example.tifannypatrianeandariontouch;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;

public class TifannyPatrianeAndariOnTouch extends Activity {

	TifannyPatrianeAndariTempatGambar tifannyPatrianeAndariTempatGambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tifanny_patriane_andari_on_touch);

        tifannyPatrianeAndariTempatGambar = new TifannyPatrianeAndariTempatGambar(this);
        tifannyPatrianeAndariTempatGambar.setBackgroundColor(Color.WHITE);
        setContentView(tifannyPatrianeAndariTempatGambar);
        tifannyPatrianeAndariTempatGambar.requestFocus();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_tifanny_patriane_andari_on_touch, menu);
        return true;
    }
}
