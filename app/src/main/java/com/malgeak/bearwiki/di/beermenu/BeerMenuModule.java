package com.malgeak.bearwiki.di.beermenu;

import com.malgeak.bearwiki.domain.BeerRepository;
import com.malgeak.bearwiki.presentation.ui.beermenu.BeerListViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class BeerMenuModule {

    @Provides
    public BeerListViewModelFactory provideBeerViewModelFactory(BeerRepository repository) {
        return new BeerListViewModelFactory(repository);
    }

}
