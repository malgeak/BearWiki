package com.malgeak.bearwiki.presentation.ui.login;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.malgeak.bearwiki.domain.LoginRepository;

public class LoginViewModelFactory implements ViewModelProvider.Factory {

    private final LoginRepository repository;

    public LoginViewModelFactory(LoginRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
       if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(repository);
       } else {
           throw new IllegalArgumentException("ViewModel Not Found");
       }
    }
}
