package com.malgeak.bearwiki.presentation.ui.beermenu;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.malgeak.bearwiki.data.model.BeerModel;
import com.malgeak.bearwiki.domain.BeerRepository;
import com.malgeak.bearwiki.presentation.ui.base.BaseViewModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BeerListViewModel extends BaseViewModel {

    private final BeerRepository repository;
    private MutableLiveData<List<BeerModel>> beerList;
    private MutableLiveData<BeerModel> selectedBeer;

    public BeerListViewModel(BeerRepository repository) {
        this.repository = repository;
        this.beerList = new MutableLiveData<>();
        this.selectedBeer = new MutableLiveData<>();

    }

    public LiveData<List<BeerModel>> getBeerList() {
        return beerList;
    }

    public LiveData<BeerModel> getBeerSelected() {
        return selectedBeer;
    }

    public void getBeerListFromRepository()   {
        setLoader(true);
        getCompositeDisposable().add(Single.fromCallable(() -> repository.getBeers())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    setLoader(false);
                    if (response.size() > 0) {
                        beerList.setValue(response);
                    } else {
                        setAlertMessage("Sorry we couldn't dowload the beer info");
                    }
                }, throwable -> {
                    setLoader(false);
                    setAlertMessage(throwable.getMessage());
                }));
    }

    public void updateBeerList()   {
        setLoader(true);
        getCompositeDisposable().add(Single.fromCallable(() -> repository.updateBeerList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    if (response.size() > 0) {
                        beerList.setValue(response);
                    } else {
                        setAlertMessage("Sorry we couldn't dowload the beer info");
                    }
                    setLoader(false);
                }, throwable -> {
                    setLoader(false);
                    setAlertMessage(throwable.getMessage());
                }));
    }

    public void selectedBer(BeerModel beer) {
        selectedBeer.setValue(beer);
    }

}
