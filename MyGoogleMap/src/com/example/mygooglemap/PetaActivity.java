package com.example.mygooglemap;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PetaActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peta);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_peta, menu);
        return true;
    }
}
