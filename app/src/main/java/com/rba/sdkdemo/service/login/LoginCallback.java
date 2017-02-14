package com.rba.sdkdemo.service.login;

import com.rba.sdkdemo.model.response.ErrorResponse;
import com.rba.sdkdemo.model.response.LoginResponse;

/**
 * Created by Ricardo Bravo on 30/01/17.
 */

public interface LoginCallback {

    void onLoginResponse(LoginResponse loginResponse);

    void onLoginError(ErrorResponse errorResponse);

}
