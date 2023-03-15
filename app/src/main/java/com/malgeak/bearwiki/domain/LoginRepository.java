package com.malgeak.bearwiki.domain;

public interface LoginRepository {

    Boolean saveUser(String name, String password);

    String getUserName();

    Boolean validUserCredentials(String password);
}
