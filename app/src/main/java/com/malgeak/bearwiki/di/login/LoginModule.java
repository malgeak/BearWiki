package com.malgeak.bearwiki.di.login;

import com.malgeak.bearwiki.domain.LoginRepository;
import com.malgeak.bearwiki.presentation.ui.login.LoginViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Provides
    public LoginViewModelFactory provideLoginViemModelFactory(LoginRepository repository) {
        return new  LoginViewModelFactory(repository);
    }
}
