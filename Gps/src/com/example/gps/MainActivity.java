package com.example.gps;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.app.Activity;
import android.view.Menu;
public class MainActivity extends Activity implements OnClickListener {
    private LocationManager locationManager;
    private EditText longitudeEditText, latitudeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        longitudeEditText = (EditText) findViewById(R.id.longtitudeEditText);
        latitudeEditText = (EditText)findViewById(R.id.latitudeEditText);

        findViewById(R.id.StartButton).setOnClickListener(this);
        findViewById(R.id.StopButton).setOnClickListener(this);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    private final LocationListener locationListener = new LocationListener() {
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onProviderDisabled(String provider) {
        }

        public void onLocationChanged(Location location) {
            latitudeEditText.setText(String.valueOf(location.getLatitude()));
            longitudeEditText.setText(String.valueOf(location.getLongitude()));
            Toast.makeText(MainActivity.this, "Dapat lokasi", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onPause() {
        locationManager.removeUpdates(locationListener);
        super.onPause();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.StartButton:
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 60000, 0, locationListener);
                break;
            case R.id.StopButton:
                locationManager.removeUpdates(locationListener);
                break;
        }
    }
}