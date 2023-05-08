package com.example.materitabview;

import android.os.Bundle;
import android.app.Activity; 
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView; 

public class MenghitungKataActivity extends Activity implements OnClickListener {
	EditText teksKataET; 
	TextView jumlahKataTV;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menghitung_kata);
        teksKataET = (EditText) findViewById(R.id.teksKataEditText);
        jumlahKataTV = (TextView) findViewById(R.id.jumlahKataTextView);
        findViewById(R.id.hitungKataButton).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menghitung_kata, menu);
        return true;
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
			case R.id.hitungKataButton:
				String teks = teksKataET.getText().toString();
				boolean kata=false, huruf;
				int i, jumlahKata=0, keyCode;
				for (i=0; i<teks.length(); i++){
					huruf = false;
					keyCode = teks.charAt(i);
					if (((keyCode >= 65) && (keyCode <= 90)) || ((keyCode >= 97) && (keyCode <= 122))){
						huruf=true;
					}
					if (huruf){
						if (!kata){
							kata = true;
							jumlahKata++;
						}
					} else {
						kata = false;
					}
				}
				
				jumlahKataTV.setText(Integer.toString(jumlahKata));
		}
	}
}
