package com.sampleint.maindetail.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.sampleint.app.ApiConstant;
import com.sampleint.maindetail.foodfragment.FoodList;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class FoodPagerdapter extends FragmentStatePagerAdapter {

    private ArrayList<String> mTabHeader;
    private final SparseArray<WeakReference<Fragment>> instantiatedFragments = new SparseArray<>();
    private String response;

    public FoodPagerdapter(FragmentManager fm, ArrayList<String> tabHeader, String reponse) {
        super(fm);
        this.mTabHeader = tabHeader;
        this.response = reponse;
    }

    @Override
    public Fragment getItem(int position) {
        FoodList tab1 = new FoodList();
        Bundle bundle = new Bundle();
        bundle.putString(ApiConstant.MAIN_DETAILS_RES, response);
        bundle.putInt(ApiConstant.MAIN_DETAILS_RES_POSITOIN, position);
        tab1.setArguments(bundle);
        return tab1;
    }

    @Override
    public int getCount() {
        return mTabHeader.size();
    }


    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        final Fragment fragment = (Fragment) super.instantiateItem(container, position);
        instantiatedFragments.put(position, new WeakReference<>(fragment));

        return fragment;
    }

    @Override
    public void destroyItem(final ViewGroup container, final int position, final Object object) {
        instantiatedFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    @Nullable
    public Fragment getFragment(final int position) {
        final WeakReference<Fragment> wr = instantiatedFragments.get(position);
        if (wr != null) {
            return wr.get();
        } else {
            return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabHeader.get(position);
    }
}
