package com.example.andri_firman_saputra_sqlite;

import com.example.andri_firman_saputra_model.AndriFirmanSaputraDataHelper;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Toast;

public class AndriFirmanSaputraAddSQLiteActivity extends Activity {

	AndriFirmanSaputraDataHelper dh;
	EditText judul, isi;
	int id = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_andri_firman_saputra_add_sqlite);

	    judul = (EditText) findViewById(R.id.judulEditText);
	    isi = (EditText) findViewById(R.id.isiEditText);

	    dh = new AndriFirmanSaputraDataHelper(this);

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
	    getMenuInflater().inflate(R.menu.activity_andri_firman_saputra_add_sqlite, menu);
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
