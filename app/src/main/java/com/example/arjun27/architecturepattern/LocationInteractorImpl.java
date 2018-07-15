package com.example.arjun27.architecturepattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationInteractorImpl implements LocationInteractor {
    @Override
    public void loadLocations(final OnFinishedListener onFinishedListener) {

        GetNoticeDataService service=RetrofitInstance.getRetrofitInstance().create(GetNoticeDataService.class);

        Call<NoticeList> call = service.getNoticeData();

        call.request().url();

        call.enqueue(new Callback<NoticeList>() {
            @Override
            public void onResponse(Call<NoticeList> call, Response<NoticeList> response) {
                onFinishedListener.onSucess(response.body());
            }

            @Override
            public void onFailure(Call<NoticeList> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });


    }
}
