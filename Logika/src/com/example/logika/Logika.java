package com.example.logika;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Logika extends Activity {
	
	// Pertama
	TextView input1, cetakNilai, cetakLogika;
	Button buttonLogika;
	
	private double nilaiLogika;
	private String cek1;
	private String cek2;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logika);
        
        //kedua
        input1 = (TextView) findViewById(R.id.NilaiEditText);
        cetakNilai = (TextView)
        findViewById(R.id.CetakNilaiTextView);
        cetakLogika = (TextView)
        findViewById(R.id.LogikaTextView);
        buttonLogika = (Button) findViewById(R.id.LogikaButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_logika, menu);
        return true;
    }
    
    // ketiga
    public void klikHitungYa(View V){
    	double inputA = Double.parseDouble(input1.getText().toString());
    	if(inputA>=80) {
    		cetakNilai.setText(""+inputA);
    		cetakLogika.setText("A");
    	}
    }
}
