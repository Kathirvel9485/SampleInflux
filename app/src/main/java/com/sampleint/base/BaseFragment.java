package com.sampleint.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class BaseFragment extends Fragment {

    public FragmentActivity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (FragmentActivity) getActivity();
    }


    public void setupRecyclerview(RecyclerView mView, int orientation, boolean divider) {
        mView.setHasFixedSize(true);
        mView.setLayoutManager(new LinearLayoutManager(mActivity, orientation, false));
        if (divider)
            mView.addItemDecoration(new DividerItemDecoration(mActivity, orientation));

        mView.setItemAnimator(new DefaultItemAnimator());
    }


    Fragment setFArgs(Fragment f, String... param) {
        Bundle args = new Bundle();
        for (int i = 0; i < param.length; i += 2) {
            args.putString(param[i], param[i + 1]);
        }
        f.setArguments(args);
        return f;
    }
}
