package com.malgeak.bearwiki.utils;

public class ValidationsUtils {

    public static Boolean validName(String name) {
        if (name.replace(" ", "").length() < 3 ) {
            return false;
        }

        return true;
    }

    public static Boolean validPassword(String password) {
        if (password.replace(" ", "").length() == 0) {
            return false;
        }

        return true;
    }
}
