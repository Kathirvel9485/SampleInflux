package com.sampleint.maindetail;

import com.sampleint.app.AppController;
import com.sampleint.app.SampleRepo;
import com.sampleint.base.AbstractBasePresenter;
import com.sampleint.data.MockyBaseResponse;
import com.sampleint.utils.DeviceUtils;

public class MainDetailPresenter extends AbstractBasePresenter<MainDetailView> {

    private MainDetailView view;
    private SampleRepo sampleRepo;
    private DeviceUtils deviceUtils;

    @Override
    public void setView(MainDetailView view) {
        this.view=view;
        sampleRepo= AppController.getInstance().getSampleRepo();
        deviceUtils=AppController.getInstance().getDeviceUtils();
    }

    public void getDetails() {
        if(deviceUtils.isNetworkAvailable()){
            view.showLoading();
            sampleRepo.getMainDetails(this);
        }else{
            view.showError("No NetWork");
        }

    }

    @Override
    public void onResponse(Object responseParser) {
       if(responseParser instanceof MockyBaseResponse){
           MockyBaseResponse baseResponse=(MockyBaseResponse)responseParser;
           handleMockyResponse(baseResponse);
       }
    }

    @Override
    public void onFailure(String message) {
        super.onFailure(message);
    }

    private void handleMockyResponse(MockyBaseResponse mockyBaseResponse) {
        view.hideLoading();
        view.mainDetailsResponse(mockyBaseResponse);
    }
}
