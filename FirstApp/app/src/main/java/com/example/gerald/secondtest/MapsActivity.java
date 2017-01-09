package com.example.gerald.secondtest;

import android.*;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng location = new LatLng(-34, 151);
    private LocationManager milocManager=null;
    private Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        milocManager= (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        if (!milocManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        else
            managedPermissions();
        marker=mMap.addMarker(new MarkerOptions().position(location).title("I'm here"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
    }


    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        managedPermissions();
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    private void managedPermissions (){

        LocationListener myListener= new LocationListener(){
            public void onLocationChanged(Location myLocation){

                location = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
                marker.setPosition(location);
                mMap.moveCamera(CameraUpdateFactory.newLatLng(location));

            }

            public void onStatusChanged(String provider, int status, Bundle extras){

            }

            public void onProviderDisabled(String provider){
                if(provider.contains("gps")){
                    Toast.makeText(getApplicationContext(), "GPS is off", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                }


            }

            public void onProviderEnabled(String provider){

            }
        } ;


        // if (checkPermission(Manifest.permission.ACCESS_FINE_LOCATION,android.os.Process.myPid(),android.os.Process.myUid())== PackageManager.PERMISSION_GRANTED)
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED)
            //coordenadas = milocManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            milocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,myListener);



}


}
