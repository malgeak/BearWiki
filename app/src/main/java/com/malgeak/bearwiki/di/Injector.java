package com.malgeak.bearwiki.di;

import com.malgeak.bearwiki.di.beermenu.BeerMenuSubComponent;
import com.malgeak.bearwiki.di.login.LoginSubComponent;

public interface Injector {

    LoginSubComponent createLoginSubcomponent();

    BeerMenuSubComponent createBeerSubcomponent();
}
