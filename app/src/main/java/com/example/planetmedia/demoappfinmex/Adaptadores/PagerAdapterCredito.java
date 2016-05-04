package com.example.planetmedia.demoappfinmex.Adaptadores;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.planetmedia.demoappfinmex.Fragmentos.fragment_inicio;


/**
 * Created by PlanetMedia on 03/05/2016.
 */
public class PagerAdapterCredito extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public PagerAdapterCredito(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                fragment_inicio tab1 = new fragment_inicio();
                return tab1;
            case 1:
                fragment_inicio tab2 = new fragment_inicio();
                return tab2;
            case 2:
                fragment_inicio tab3 = new fragment_inicio();
                return tab3;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
