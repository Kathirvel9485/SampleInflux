package com.sampleint.app;

import com.sampleint.data.MockyBaseResponse;

import retrofit2.Call;
import retrofit2.http.POST;

public interface SampleApi {

    /*Details API*/
    @POST(ApiUrl.API_DETAILS)
    Call<MockyBaseResponse> getDetails();
}
