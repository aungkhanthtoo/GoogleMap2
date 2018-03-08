package com.lesson.san.googlemap;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

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

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        LatLng thanStreet = new LatLng(16.8451098, 96.1235901);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(thanStreet).title("Marker in ThanStreet");
        mMap.addMarker(markerOptions);
//        CameraUpdate myPlace = CameraUpdateFactory.newLatLng(thanStreet);
//        CameraUpdate zoom = CameraUpdateFactory.zoomTo(20);
//
//        mMap.moveCamera(myPlace);
//        mMap.animateCamera(zoom);

        LatLng last = new LatLng(16.9451098, 106.1235901);
        MarkerOptions markerOptionsLast = new MarkerOptions();
        markerOptionsLast.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        markerOptionsLast.position(last).title("Marker in Last");
        mMap.addMarker(markerOptionsLast);

        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.add(thanStreet, last).width(3).color(Color.GREEN);
        mMap.addPolyline(polylineOptions);

        LatLng halfWay = new LatLng((thanStreet.latitude + last.latitude)/2, (thanStreet.longitude + last.longitude) / 2);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(halfWay));
        // www.mapstyle.withgoogle.com to change map style json and load from raw

    }
}
