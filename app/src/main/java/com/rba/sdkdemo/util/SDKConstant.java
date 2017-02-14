package com.rba.sdkdemo.util;

/**
 * Created by Ricardo Bravo on 14/02/17.
 */

public class SDKConstant {

    static {
        System.loadLibrary("native-lib");
    }

    public static String BASE_URL = stringBaseUrl();
    public static final String LOGIN_URL = stringLoginUrl();
    public static final String REGISTER_URL = stringRegisterUrl();
    public static final String LOGIN = "login/";

    public static native String stringBaseUrl();
    public static native String stringLoginUrl();
    public static native String stringRegisterUrl();

}
