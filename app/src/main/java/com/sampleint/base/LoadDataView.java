package com.sampleint.base;

public interface LoadDataView extends BaseView{

    void showLoading();

    void hideLoading();

    void showError(String message);
}
