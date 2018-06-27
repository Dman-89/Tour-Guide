package com.example.android.tourguide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CityAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    /**
     * Create a new {@link CityAdapter} object.
     * We could return a hardcoded string such as “Vladimir,” “Suzdal,” and so on.
     * However, we don’t want to restrict our app
     * to only support the English language. Instead, we should use
     * the string resource for those category names.
     * Unfortunately, that also means we need a Context object in order to turn
     * the string resource ID into an actual String.
     * So we modify the CityAdapter constructor to also require
     * a Context input so that we can get the proper text string.
     *
     * @param context is the context of the app
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public CityAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new VladimirFragment();
        } else if (position == 1) {
            return new VladimirFragment();
        } else if (position == 2) {
            return new VladimirFragment();
        } else {
            return new VladimirFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.vladimir);
        } else if (position == 1) {
            return mContext.getString(R.string.suzdal);
        } else if (position == 2) {
            return mContext.getString(R.string.raduzhnyy);
        } else {
            return mContext.getString(R.string.about);
        }
    }
}
