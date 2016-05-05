package com.example.planetmedia.demoappfinmex.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.planetmedia.demoappfinmex.fragments.AdministracionFragment;
import com.example.planetmedia.demoappfinmex.fragments.CreditosFragment;
import com.example.planetmedia.demoappfinmex.fragments.MisCuentasFragment;

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
                MisCuentasFragment tab1 = new MisCuentasFragment();
                return tab1;
            case 1:
                CreditosFragment tab2 = new CreditosFragment();
                return tab2;
            case 2:
                AdministracionFragment tab3 = new AdministracionFragment();
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
