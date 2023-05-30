package com.example.mygooglemap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MainActivity extends Activity implements OnItemClickListener {

    static final String PROPINSI = "propinsi";
    static final String IBUKOTA = "ibukota";
    static final String LONGITUDE = "longitude";
    static final String LATITUDE = "latitude";

    private List<Map<String, String>> items;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText("");

        listView = (ListView) findViewById(R.id.listView1);
        listView.setOnItemClickListener(this);
        registerForContextMenu(listView);

        items = new ArrayList();
        addItem("Jawa Barat", "Bandung", "-6.912063", "107.606084");
        addItem("Jawa Tengah", "Semarang", "-6.970239", "110.424404");
        addItem("Jawa Timur", "Surabaya", "-7.28866", "112.734311");

        String[] from = {PROPINSI, IBUKOTA, LATITUDE, LONGITUDE};
        int[] to = {R.id.textView1, R.id.textView2};

        SimpleAdapter adapter = new SimpleAdapter(this, items, R.layout.activity_main, from, to);
        listView.setAdapter(adapter);
    }

    private void addItem(String propinsi, String ibukota, String latitude, String longitude) {
        Map<String, String> map = new HashMap();
        map.put(PROPINSI, propinsi);
        map.put(IBUKOTA, ibukota);
        map.put(LATITUDE, latitude);
        map.put(LONGITUDE, longitude);
        items.add(map);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Intent intent = new Intent(this, PetaActivity.class);
        intent.putExtra(PROPINSI, items.get(arg2).get(PROPINSI));
        intent.putExtra(IBUKOTA, items.get(arg2).get(IBUKOTA));
        intent.putExtra(LONGITUDE, items.get(arg2).get(LONGITUDE));
        intent.putExtra(LATITUDE, items.get(arg2).get(LATITUDE));
        startActivity(intent);
    }
}
