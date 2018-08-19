package com.sampleint.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.sampleint.app.AppController;

public class BaseActivity extends AppCompatActivity {

    protected FragmentActivity act;
    public AppController appController;
    public Gson gson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = this;
        appController = (AppController)this.getApplicationContext();
         gson= AppController.getInstance().getGson();
    }


}
