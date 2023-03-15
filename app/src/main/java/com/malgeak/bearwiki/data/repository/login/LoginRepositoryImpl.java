package com.malgeak.bearwiki.data.repository.login;

import com.malgeak.bearwiki.data.repository.login.datasource.LoginLocalDataSource;
import com.malgeak.bearwiki.domain.LoginRepository;

public class LoginRepositoryImpl implements LoginRepository {

    private final LoginLocalDataSource localDataSource;

    public LoginRepositoryImpl(LoginLocalDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }

    @Override
    public Boolean saveUser(String name, String password) {
        localDataSource.saveName(name);
        localDataSource.savePassword(password);
        return true;
    }

    @Override
    public String getUserName() {
        return localDataSource.getName();
    }

    @Override
    public Boolean validUserCredentials(String password) {
        return (password.contentEquals(localDataSource.getPassword()));
    }
}
