package com.malgeak.bearwiki.presentation.ui.beermenu;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.malgeak.bearwiki.domain.BeerRepository;

public class BeerListViewModelFactory implements ViewModelProvider.Factory {

    private final BeerRepository repository;

    public BeerListViewModelFactory(BeerRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(BeerListViewModel.class)) {
            return (T) new BeerListViewModel(repository);
        } else {
            throw new IllegalArgumentException("View Model Not Found");
        }
    }
}
