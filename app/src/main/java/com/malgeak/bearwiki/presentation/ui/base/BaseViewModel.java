package com.malgeak.bearwiki.presentation.ui.base;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class BaseViewModel extends ViewModel {

    private final MutableLiveData<Boolean> loader;
    private final MutableLiveData<String> alertMessage;

    public final int VISIBLE = View.VISIBLE;
    public final int GONE = View.GONE;

    private CompositeDisposable compositeDisposable;

    public BaseViewModel() {
        this.compositeDisposable = new CompositeDisposable();
        this.loader = new MutableLiveData<>();
        this.alertMessage = new MutableLiveData<>();

        loader.setValue(false);
    }

    public LiveData<Boolean> getLoader() {
        return loader;
    }

    public void setLoader(boolean isLoading) {
        loader.setValue(isLoading);
    }

    public LiveData<String> getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String message) {
        alertMessage.setValue(message);
    }
    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }
}
