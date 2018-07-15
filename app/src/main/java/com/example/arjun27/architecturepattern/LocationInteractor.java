package com.example.arjun27.architecturepattern;

public interface LocationInteractor {

    interface OnFinishedListener{
        public void onSucess(NoticeList noticelist);
        public void onFailure(Throwable t);
    }

    void loadLocations(OnFinishedListener onFinishedListener);
}
