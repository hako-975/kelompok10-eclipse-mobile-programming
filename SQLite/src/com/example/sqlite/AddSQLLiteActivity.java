package com.example.sqlite;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AddSQLLiteActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sqllite);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_add_sqllite, menu);
        return true;
    }
}
