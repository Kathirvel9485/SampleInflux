package com.sampleint.base;

public interface BasePresenter <V extends BaseView> {

    void setView(V view);
}
