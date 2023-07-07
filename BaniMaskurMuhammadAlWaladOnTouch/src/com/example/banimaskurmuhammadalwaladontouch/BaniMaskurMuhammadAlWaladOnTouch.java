package com.example.banimaskurmuhammadalwaladontouch;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;

public class BaniMaskurMuhammadAlWaladOnTouch extends Activity {

	BaniMaskurMuhammadAlWaladTempatGambar baniMaskurMuhammadAlWaladTempatGambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bani_maskur_muhammad_al_walad_on_touch);

        baniMaskurMuhammadAlWaladTempatGambar = new BaniMaskurMuhammadAlWaladTempatGambar(this);
        baniMaskurMuhammadAlWaladTempatGambar.setBackgroundColor(Color.WHITE);
        setContentView(baniMaskurMuhammadAlWaladTempatGambar);
        baniMaskurMuhammadAlWaladTempatGambar.requestFocus();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_bani_maskur_muhammad_al_walad_on_touch, menu);
        return true;
    }
}
