package com.sampleint.app;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sampleint.utils.DeviceUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.sampleint.app.ApiConstant.BASE_URL;

public class AppController extends Application{

    private static AppController appController;
    private SampleRepo sampleRepo;
    private  DeviceUtils deviceUtils;
    private Gson gson;

    public static AppController getInstance() {
        return appController;

    }


    @Override
    public void onCreate() {
        super.onCreate();
        appController=this;
        gson = new GsonBuilder().create();
    }

    public SampleRepo getSampleRepo(){
        if (sampleRepo == null) sampleRepo = createSampleRepo();
        return sampleRepo;
    }

    public DeviceUtils getDeviceUtils() {
        if (deviceUtils == null) {
            deviceUtils = new DeviceUtils(this);
        }
        return deviceUtils;
    }
    private SampleRepo createSampleRepo() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS);
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        .header("Accept", "application/json")
                        .method(original.method(), original.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });
        OkHttpClient client = httpClient.build();
        Retrofit retrofit=new Retrofit.Builder().client(client)
                .baseUrl(ApiConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
        return new SampleRepo(retrofit.create(SampleApi.class));

    }

    public Gson getGson() {
        return gson;
    }
}
