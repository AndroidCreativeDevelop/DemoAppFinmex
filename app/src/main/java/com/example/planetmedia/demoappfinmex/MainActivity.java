package com.example.planetmedia.demoappfinmex;

import android.app.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.planetmedia.demoappfinmex.fragments.LoginFragment;
import com.example.planetmedia.demoappfinmex.fragments.SolicitudFragment;

public class MainActivity extends AppCompatActivity {
    Fragment fragment;
    FragmentManager frag;
    FragmentTransaction ft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
