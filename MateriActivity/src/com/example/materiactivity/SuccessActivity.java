package com.example.materiactivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SuccessActivity extends Activity implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        TextView namaUserTV = (TextView) findViewById(R.id.namaUserTextView);
        namaUserTV.setText (getIntent().getExtras().getString("namaUser"));
        findViewById(R.id.logoutButton).setOnClickListener(this); 
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_success, menu);
        return true;
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
			case R.id.logoutButton:
				finish();
		} 
	}
}
