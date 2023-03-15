package com.malgeak.bearwiki.di.login;

import com.malgeak.bearwiki.presentation.ui.login.LoginFragment;

import dagger.Subcomponent;

@LoginScope
@Subcomponent(modules = {LoginModule.class})
public interface LoginSubComponent {

    void inject(LoginFragment loginFragment);

    @Subcomponent.Factory
    interface Factory {
        LoginSubComponent create();
    }
}
