package com.example.andri_firman_saputra_ontouch;


import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color; 
import android.view.Menu;

public class AndriFirmanSaputraOnTouch extends Activity {

	AndriFirmanSaputraTempatGambar tempatGambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andri_firman_saputra_on_touch);

        tempatGambar = new AndriFirmanSaputraTempatGambar(this);
        tempatGambar.setBackgroundColor(Color.WHITE);
        setContentView(tempatGambar);
        tempatGambar.requestFocus();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_andri_firman_saputra_on_touch, menu);
        return true;
    }
}
