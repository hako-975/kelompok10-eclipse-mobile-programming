package com.example.materiactivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener; 

public class FailedActivity extends Activity implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failed);
        findViewById(R.id.kembaliButton).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_failed, menu);
        return true;
    }
    
    public void onClick(View v) {
    	 // TODO Auto-generated method stub
    	 switch (v.getId()){
    	 	case R.id.kembaliButton:
    	 		finish();
    	 }
    }
}
