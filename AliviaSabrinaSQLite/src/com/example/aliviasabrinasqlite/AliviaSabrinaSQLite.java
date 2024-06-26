package com.example.aliviasabrinasqlite;

import com.example.aliviasabrinamodel.AliviaSabrinaDataHelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast; 

public class AliviaSabrinaSQLite extends Activity implements OnClickListener, OnItemLongClickListener {
	ListView listView;
	SimpleCursorAdapter adapter;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_alivia_sabrina_sqlite);

	    listView = (ListView) findViewById(R.id.listView1);
	    listView.setOnItemLongClickListener(this);

	    findViewById(R.id.tambahButton).setOnClickListener(this);
	    findViewById(R.id.refreshButton).setOnClickListener(this);

	    AliviaSabrinaDataHelper dh = new AliviaSabrinaDataHelper(this);
	    Cursor c = dh.getAll();
	    String[] from = new String[]{"judul", "isi"};
	    int[] to = new int[]{android.R.id.text1, android.R.id.text2};

	    try {
	        adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, c, from, to);
	    } catch (Exception ex) {
	        // Handle the exception
	    }

	    listView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.activity_alivia_sabrina_sqlite, menu);
	    return true;
	}

	@Override
	protected void onResume() {
	    adapter.notifyDataSetChanged();
	    super.onResume();
	}

	public void onClick(View v) {
	    switch (v.getId()) {
	        case R.id.tambahButton:
	            startActivity(new Intent(this, AliviaSabrinaAddSQLite.class));
	            break;
	        case R.id.refreshButton:
	        	AliviaSabrinaDataHelper dh = new AliviaSabrinaDataHelper(this);
	            Cursor c = dh.getAll();
	            String[] from = new String[]{"judul", "isi"};
	            int[] to = new int[]{android.R.id.text1, android.R.id.text2};

	            try {
	                adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, c, from, to);
	            } catch (Exception ex) {
	                // Handle the exception
	            }

	            listView.setAdapter(adapter);
	            break;
	        default:
	            break;
	    }
	}

	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	    final int id = (int) adapter.getItemId(arg2);
	    AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    builder.setMessage("Apakah id=" + id + " akan dihapus")
	            .setCancelable(true)
	            .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
	                public void onClick(DialogInterface dialog, int which) {
	                    hapusData(id);
	                }
	            })
	            .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
	                public void onClick(DialogInterface dialog, int which) {
	                    dialog.cancel();
	                }
	            });

	    AlertDialog alertDialog = builder.create();
	    alertDialog.show();
	    return false;
	}

	private void hapusData(long id) {
		AliviaSabrinaDataHelper dh = new AliviaSabrinaDataHelper(this);
	    try {
	        dh.deleteById((int) id);
	    } catch (Exception ex) {
	        Toast.makeText(this, "Error: " + ex.getMessage(), Toast.LENGTH_LONG).show();
	    }
	}
}
