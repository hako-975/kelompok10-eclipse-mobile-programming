package com.example.mygooglemaps;


import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.OverlayItem;

import java.util.ArrayList;
import android.app.Activity;
import android.view.Menu;
public class PetaActivity extends MapActivity {

    private MapView mapView;
    private MapController mapController;
    private ArrayList<OverlayItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peta);

        mapView = (MapView) findViewById(R.id.peta);
        mapController = mapView.getController();
        mapView.setClickable(true);
        mapView.setEnabled(true);
        mapView.setBuiltInZoomControls(true);
        mapController.setZoom(16);

        // Overlay my location
        final MyLocationOverlay myLocationOverlay = new MyLocationOverlay(this, mapView);
        myLocationOverlay.enableCompass();
        myLocationOverlay.enableMyLocation();
        myLocationOverlay.runOnFirstFix(new Runnable() {
            public void run() {
                mapController.animateTo(myLocationOverlay.getMyLocation());
            }
        });

        mapView.getOverlays().add(myLocationOverlay);

        items = new ArrayList();
        Bundle extra = getIntent().getExtras();

        if (extra != null) {
            String namaPropinsi = extra.getString(MainActivity.PROPINSI);
            String longitude = extra.getString(MainActivity.LONGITUDE);
            String latitude = extra.getString(MainActivity.LATITUDE);
            String ibukota = extra.getString(MainActivity.IBUKOTA);

            Drawable drawable = this.getResources().getDrawable(R.drawable.ic_launcher);
            HelloItemizedOverlay helloItemizedOverlay = new HelloItemizedOverlay(drawable);
            GeoPoint p = new GeoPoint((int) (Double.parseDouble(latitude) * 1E6),
                    (int) (Double.parseDouble(longitude) * 1E6));
            OverlayItem item = new OverlayItem(p, namaPropinsi, ibukota);
            helloItemizedOverlay.addItem(item);
            mapView.getOverlays().add(helloItemizedOverlay);
            mapController.animateTo(p);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_peta, menu);
        return true;
    }

    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }

    private class HelloItemizedOverlay extends ItemizedOverlay<OverlayItem> {

        public HelloItemizedOverlay(Drawable defaultMarker) {
            super(boundCenterBottom(defaultMarker));
        }

        @Override
        protected OverlayItem createItem(int i) {
            return items.get(i);
        }

        @Override
        public int size() {
            return items.size();
        }

        public void addItem(OverlayItem overlay) {
            items.add(overlay);
            populate();
        }

        @Override
        protected boolean onTap(int index) {
            OverlayItem item = items.get(index);

            AlertDialog.Builder dialog = new AlertDialog.Builder(PetaActivity.this);
            dialog.setTitle(item.getTitle());
            dialog.setMessage(item.getSnippet());
            dialog.show();
            return true;
        }
    }
}