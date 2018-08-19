package com.sampleint.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sampleint.data.MockyBaseResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SampleRepo {

    public SampleApi sampleApi;

    public SampleRepo(SampleApi sampleApi) {
        this.sampleApi = sampleApi;
    }

    public void getMainDetails(final ResponseHandler handler) {
        Call<MockyBaseResponse> responseCall = sampleApi.getDetails();
        responseCall.enqueue(new Callback<MockyBaseResponse>() {
            @Override
            public void onResponse(Call<MockyBaseResponse> call, Response<MockyBaseResponse> response) {
                if (response != null) {
                    MockyBaseResponse baseResponse = response.body();
                    if (response.isSuccessful()) {
                        handler.onResponse(baseResponse);
                    } else {
                        try {
                            handler.onFailure(baseResponse != null ? baseResponse.getStatus().getDescription() : ApiConstant.UNABLE_PROCESS);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<MockyBaseResponse> call, Throwable t) {
                handler.onFailure(t.getMessage());
            }
        });
    }

}
