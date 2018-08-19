package com.sampleint.app;

public interface ResponseHandler {

    void onResponse(Object responseParser);

    void onFailure(String message);
}
