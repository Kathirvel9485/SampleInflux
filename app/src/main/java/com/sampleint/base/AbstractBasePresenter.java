package com.sampleint.base;

import com.sampleint.app.ResponseHandler;

public class AbstractBasePresenter <V extends BaseView> implements BasePresenter<V>,ResponseHandler{



    @Override
    public void setView(V view) {

    }


    @Override
    public void onResponse(Object responseParser) {

    }

    @Override
    public void onFailure(String message) {

    }
}
