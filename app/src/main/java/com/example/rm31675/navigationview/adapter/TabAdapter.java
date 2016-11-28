package com.example.rm31675.navigationview.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.rm31675.navigationview.fragments.TimesFragment;

/**
 * Created by rm31675 on 19/11/2016.
 */
public class TabAdapter extends FragmentStatePagerAdapter {

    public static final int TOTAL_TABS=1;

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = new TimesFragment();
        return f;
    }

    @Override
    public int getCount() {
        return TOTAL_TABS;
    }
}
