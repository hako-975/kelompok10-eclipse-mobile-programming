package com.example.materitabview;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost; 

public class MainActivity extends TabActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Intent intent;
        TabHost tabHost = getTabHost();
        TabHost.TabSpec tabSpec;
        intent = new Intent(this, MenghitungHurufActivity.class);
        tabSpec = getTabHost().newTabSpec("tab1").setIndicator("Menghitung Huruf").setContent(intent);
        tabHost.addTab(tabSpec);
        intent = new Intent(this, MenghitungKataActivity.class);
        tabSpec = getTabHost().newTabSpec("tab2").setIndicator("Menghitung Kata").setContent(intent);
        tabHost.addTab(tabSpec); 
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
