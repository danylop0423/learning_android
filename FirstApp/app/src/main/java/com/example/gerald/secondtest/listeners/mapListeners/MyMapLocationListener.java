package com.example.gerald.secondtest.listeners.mapListeners;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by javieralejos on 10/1/17.
 */

public class MyMapLocationListener implements LocationListener {


    private GoogleMap mMap;
    private LatLng location = new LatLng(-34, 151);
    private Marker marker;
    private Activity myMap;

    public MyMapLocationListener(LatLng location, Marker marker, GoogleMap mMap,Activity myMap) {

        this.location=location;
        this.marker=marker;
        this.mMap=mMap;
        this.myMap=myMap;

    }

    public void onLocationChanged(Location myLocation){

        location = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
        marker.setPosition(location);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));

    }

    public void onStatusChanged(String provider, int status, Bundle extras){

    }

    public void onProviderDisabled(String provider){
        if(provider.contains("gps")){
            Toast.makeText(myMap.getApplicationContext(), "GPS is off", Toast.LENGTH_LONG).show();
            myMap.startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
        }


    }

    public void onProviderEnabled(String provider){

    }
}
