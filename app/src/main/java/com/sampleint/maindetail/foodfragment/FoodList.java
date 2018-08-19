package com.sampleint.maindetail.foodfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sampleint.R;
import com.sampleint.app.ApiConstant;
import com.sampleint.app.AppController;
import com.sampleint.base.BaseFragment;
import com.sampleint.data.MockyBaseResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodList extends BaseFragment {


    private MockyBaseResponse mockyBaseResponse = null;
    private FoodListAdapter adapter;

    @BindView(R.id.recy_foodlist)
    RecyclerView recyFood;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_foodlist, container, false);
        ButterKnife.bind(this,v);
        init(v);
        return v;
    }

    private void init(View v) {
        setupRecyclerview(recyFood, RecyclerView.VERTICAL, false);
        adapter=new FoodListAdapter(getContext());
        recyFood.setAdapter(adapter);
        if (getArguments() != null) {
            String response = getArguments().getString(ApiConstant.MAIN_DETAILS_RES);
            mockyBaseResponse = AppController.getInstance().getGson().fromJson(response, MockyBaseResponse.class);
            int position=getArguments().getInt(ApiConstant.MAIN_DETAILS_RES_POSITOIN);
            adapter.setCommonList(mockyBaseResponse.getFoodList().get(position).getFnblist());
        }
    }


}
