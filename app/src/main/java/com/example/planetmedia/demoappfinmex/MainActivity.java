package com.example.planetmedia.demoappfinmex;

import android.app.Activity;

import android.app.Dialog;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.planetmedia.demoappfinmex.fragments.LoginFragment;
import com.example.planetmedia.demoappfinmex.fragments.SolicitudFragment;
import com.example.planetmedia.demoappfinmex.fragments.contactoFragment;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LocationListener,GpsStatus.Listener {
    Fragment fragment;
    FragmentManager frag;
    FragmentTransaction ft;
    GoogleMap googleMap;
    boolean ValidarGps = false;
    boolean FailedException = false;
    LocationManager locationManager;
    Activity Act;
    private GoogleApiClient mGoogleApiClient;
    protected Location mLastLocation;

    private final static int
            CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Act = this;
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        fragment = new LoginFragment();
        frag = this.getSupportFragmentManager();
        ft = frag.beginTransaction();
        ft.add(R.id.container, fragment);
        ft.commit();
        fragment= new SolicitudFragment();
        frag = this.getSupportFragmentManager();
        ft = frag.beginTransaction();
        ft.add(R.id.container2, fragment);
        ft.commit();
        fragment= new contactoFragment();
        frag = this.getSupportFragmentManager();
        ft = frag.beginTransaction();
        ft.add(R.id.ContentContacto, fragment);
        ft.commit();

        mGoogleApiClient = new GoogleApiClient.Builder(this).addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
            @Override
            public void onConnected(Bundle bundle) {
                mLastLocation = LocationServices.FusedLocationApi
                        .getLastLocation(mGoogleApiClient);
                double latitude = mLastLocation.getLatitude();

                // Getting longitude of the current location}
                double longitude = mLastLocation.getLongitude();

                // Creating a LatLng object for the current location
                LatLng latLng = new LatLng(latitude, longitude);


                // Showing the current location in Google Map
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

                // Zoom in the Google Map
                googleMap.animateCamera(CameraUpdateFactory.zoomTo(15));

            }

            @Override
            public void onConnectionSuspended(int i) {

            }
        }).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
            @Override
            public void onConnectionFailed(ConnectionResult connectionResult) {
                if (connectionResult.hasResolution()){
                    try{
                        connectionResult.startResolutionForResult(MainActivity.this,
                                CONNECTION_FAILURE_RESOLUTION_REQUEST);
                    }catch(IntentSender.SendIntentException e){
                        e.printStackTrace();
                    }
                }



            }
        }).addApi(LocationServices.API).build();


        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        try{
            locationManager.addGpsStatusListener(this);
        }
        catch (SecurityException e){
            FailedException =true;
        }
        if (FailedException)
        ValidarGps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        else
        ValidarGps=false;

        if(ValidarGps){
            getmap();
        }else if (FailedException){
            System.out.println("Provider Disable");

            boolean Acercar = false;
            getmap();

        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    //----------------------------- MAPS------------------------------------------------------------

    public void getmap() {

        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());


        if(status!= ConnectionResult.SUCCESS){
            // Google Play Services are not available

            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this, requestCode);
            dialog.show();

        }else {

            SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);


            googleMap = fm.getMap();

            googleMap.setMyLocationEnabled(true);

            Criteria criteria = new Criteria();
            criteria.setAccuracy(Criteria.ACCURACY_FINE);
            criteria.setAltitudeRequired(false);
            criteria.setBearingRequired(false);
            criteria.setCostAllowed(true);
            criteria.setPowerRequirement(Criteria.POWER_HIGH);

            // Getting the name of the best provider
            String provider = locationManager.getBestProvider(criteria,false);

            if(getLastKnownLocation()!=null){
                System.out.println("is not null tha last location");
                onLocationChanged(getLastKnownLocation());
            }
            try{
                locationManager.requestLocationUpdates(provider, 0, 0, this);
            }catch (SecurityException | NullPointerException e){
                System.out.println("Location Manager "+ e.getMessage());
                Toast.makeText(Act, "Turn On The GPS!!",
                        Toast.LENGTH_LONG).show();
            }

        }
    }



    @Override
    public void onLocationChanged(Location location) {
        // Getting latitude of the current location
        double latitude = location.getLatitude();

        // Getting longitude of the current location}
        double longitude = location.getLongitude();

        // Creating a LatLng object for the current location
        LatLng latLng = new LatLng(latitude, longitude);


            // Showing the current location in Google Map
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

            // Zoom in the Google Map
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(15));

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        Location location = new Location(provider);
        onLocationChanged(location);

    }

    @Override
    public void onProviderDisabled(String provider) {

        onLocationChanged(new Location(provider));
    }

    @Override
    public void onGpsStatusChanged(int event) {

    }

    //------------------------------------------------- Location

    public Location getLastKnownLocation() {

        List<String> providers = locationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            try{
                Location l = locationManager.getLastKnownLocation(provider);
                if (l == null) {
                    continue;
                }
                if (bestLocation == null
                        || l.getAccuracy() < bestLocation.getAccuracy()) {
                    bestLocation = l;
                }
            }
            catch (SecurityException | NullPointerException   e){
                System.out.println("Segurity Exception " + e.getMessage());

                Toast.makeText(Act, "Turn On The GPS!!",
                        Toast.LENGTH_LONG).show();
            }


        }
        if (bestLocation == null) {
            System.out.println("Segurity Exception Null Provider ");
            return null;
        }
        return bestLocation;
    }





}
