package com.malgeak.bearwiki.data.repository.login.datasource;

public interface LoginLocalDataSource {

    void saveName(String name);

    void savePassword(String password);

    String getName();

    String getPassword();
}
