package com.malgeak.bearwiki.di.beermenu;


import com.malgeak.bearwiki.presentation.ui.beermenu.BeerListFragment;

import dagger.Subcomponent;

@BeerMenuScope
@Subcomponent(modules = {BeerMenuModule.class})
public interface BeerMenuSubComponent {

    void inject(BeerListFragment beerListFragment);

    @Subcomponent.Factory
    interface Factory {

        BeerMenuSubComponent create();
    }
}


