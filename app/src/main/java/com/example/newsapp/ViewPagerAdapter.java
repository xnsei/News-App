package com.example.newsapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public ViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new BusinessFragment();

            case 1:
                return new EntertainmentFragment();

            case 2:
                return new GeneralFragment();

            case 3:
                return new HealthFragment();

            case 4:
                return new ScienceFragment();

            case 5:
                return new SportsFragment();

            case 6:
                return new TechnologyFragment();

            default:
                return  null;
        }
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.fragment_business);
            case 1:
                return mContext.getString(R.string.fragment_entertainment);
            case 2:
                return mContext.getString(R.string.fragment_general);
            case 3:
                return mContext.getString(R.string.fragment_health);
            case 4:
                return mContext.getString(R.string.fragment_science);
            case 5:
                return mContext.getString(R.string.fragment_sports);
            case 6:
                return mContext.getString(R.string.fragment_technology);
            default:
                return null;
        }
    }
}
