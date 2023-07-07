package com.example.banimaskurmuhammadalwaladsqlite;

import com.example.banimaskurmuhammadalwaladmodel.BaniMaskurMuhammadAlWaladDataHelper;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Toast;

public class BaniMaskurMuhammadAlWaladAddSQLite extends Activity {
	BaniMaskurMuhammadAlWaladDataHelper dh;
	EditText judul, isi;
	int id = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_bani_maskur_muhammad_al_walad_add_sqlite);

	    judul = (EditText) findViewById(R.id.judulEditText);
	    isi = (EditText) findViewById(R.id.isiEditText);

	    dh = new BaniMaskurMuhammadAlWaladDataHelper(this);

	    if (getIntent().getExtras() != null) {
	        id = getIntent().getIntExtra("_id", 0);
	        Cursor c = dh.getById(id);

	        if (c.moveToFirst()) { // Assuming there's only one record with the unique _id
	            do {
	                String strJudul = c.getString(c.getColumnIndex("judul"));
	                String strIsi = c.getString(c.getColumnIndex("isi"));
	                // TODO: Populate the field with the retrieved data
	            } while (c.moveToNext());
	        }
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.activity_bani_maskur_muhammad_al_walad_add_sqlite, menu);
	    return true;
	}

	@Override
	protected void onPause() {
	    if (!judul.getText().toString().equals("")) {
	        if (id > 0) {
	            // TODO: Update the database
	        } else {
	            id = (int) dh.insert2(judul.getText().toString(), isi.getText().toString());
	            Toast.makeText(this, "Disimpan: " + Integer.toString(id) + ": " + judul.getText(),
	                    Toast.LENGTH_SHORT).show();
	        }
	    }
	    super.onPause();
	}
}
