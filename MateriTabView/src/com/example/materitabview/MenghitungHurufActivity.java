package com.example.materitabview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView; 
import android.app.Activity;
import android.view.Menu;

public class MenghitungHurufActivity extends Activity  implements OnClickListener {
	EditText teksHurufET;
	TextView jumlahVokalTV, jumlahKonsonanTV;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menghitung_huruf);
        teksHurufET = (EditText) findViewById(R.id.teksHurufEditText);
        jumlahVokalTV = (TextView)
        findViewById(R.id.jumlahVokalTextView);
        jumlahKonsonanTV = (TextView)
        findViewById(R.id.jumlahKonsonanTextView);

        findViewById(R.id.hitungHurufButton).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menghitung_huruf, menu);
        return true;
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
			case R.id.hitungHurufButton:
				String teks = teksHurufET.getText().toString();
				String[] listVokal = {"A","E","I","O","U"};
				int jumlahVokal=0, jumlahKonsonan=0;
				int i,j;
				boolean vokal;
				
				for (i=0; i<teks.length(); i++){
					int keyCode = teks.charAt(i);
					if (((keyCode >= 65) && (keyCode <= 90)) || ((keyCode >= 97) && (keyCode <= 122))){
						vokal = false;
						j=0;
						while ((j<listVokal.length) &&!vokal){ 
							if (teks.substring(i, i+1).equalsIgnoreCase(listVokal[j++])){
								vokal = true;
							}
						}
					
						if (vokal){
							jumlahVokal++;
						} else {
							jumlahKonsonan++;
						}
					}
				}
				
			jumlahVokalTV.setText(Integer.toString(jumlahVokal));
			jumlahKonsonanTV.setText(Integer.toString(jumlahKonsonan));
		}
	}
		
}
