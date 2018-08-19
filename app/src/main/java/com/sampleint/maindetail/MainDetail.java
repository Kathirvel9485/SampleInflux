package com.sampleint.maindetail;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.sampleint.R;
import com.sampleint.app.AppController;
import com.sampleint.base.BaseActivity;
import com.sampleint.data.FoodListItem;
import com.sampleint.data.MockyBaseResponse;
import com.sampleint.maindetail.adapter.FoodPagerdapter;
import com.sampleint.utils.Loading;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainDetail extends BaseActivity implements MainDetailView {

    private MainDetailPresenter presenter;
    private Dialog dialog;
    private FoodPagerdapter foodPagerdapter;

    //TabView
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.viewpagertab)
    SmartTabLayout mTabView;

    //TabView heading Array
    ArrayList<String> tabs = new ArrayList<>();

    private MockyBaseResponse mockyBaseResponse=null;
    private String reponseMain="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();

    }

    private void init() {
        presenter = new MainDetailPresenter();
        presenter.setView(this);
        getMainDetails();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
              if(reponseMain.length()!=0){

              }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void getMainDetails() {
        presenter.getDetails();
    }


    @Override
    public void mainDetailsResponse(MockyBaseResponse mockyBaseResponse) {
        if (mockyBaseResponse != null) {
             reponseMain=gson.toJson(mockyBaseResponse);
            for (int i = 0; i < mockyBaseResponse.getFoodList().size(); i++) {
                FoodListItem foodListItem = mockyBaseResponse.getFoodList().get(i);
                tabs.add(foodListItem.getTabName());
            }
            foodPagerdapter = new FoodPagerdapter(act.getSupportFragmentManager(), tabs,reponseMain);
            viewPager.setAdapter(foodPagerdapter);
            mTabView.setViewPager(viewPager);
        }


    }

    @Override
    public void showLoading() {
        try {
            if (dialog == null) {
                dialog = Loading.showLoadingDialog(this, false);
                dialog.show();
            } else dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hideLoading() {
        try {
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showError(String message) {
        Toast.makeText(act, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return act;
    }
}
