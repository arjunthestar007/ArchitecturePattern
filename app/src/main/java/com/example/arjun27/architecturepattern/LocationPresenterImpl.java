package com.example.arjun27.architecturepattern;

public class LocationPresenterImpl implements LocationPresenter, LocationInteractor.OnFinishedListener {

    LocationInteractor locationInteractor;
    LocationInterface locationInterface;

    public LocationPresenterImpl(LocationInterface locationInterface) {
        this.locationInterface = locationInterface;
        this.locationInteractor = new LocationInteractorImpl();

    }


    @Override
    public void loadLocations() {
        if (locationInterface != null) {
            locationInterface.showProgress();
        }
        locationInteractor.loadLocations(this);
    }

    @Override
    public void onDestroy() {
        locationInterface = null;
    }

    @Override
    public void onSucess(NoticeList noticelist) {
        if (locationInterface != null) {
            locationInterface.locationLoaded(noticelist);
            locationInterface.hideProgress();
        }

    }

    @Override
    public void onFailure(Throwable t) {
        if (locationInterface != null) {
            locationInterface.locationLoaded(null);
            locationInterface.hideProgress();
        }
    }
}
