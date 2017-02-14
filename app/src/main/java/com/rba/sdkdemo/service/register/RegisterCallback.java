package com.rba.sdkdemo.service.register;

import com.rba.sdkdemo.model.response.ErrorResponse;
import com.rba.sdkdemo.model.response.RegisterResponse;

/**
 * Created by Ricardo Bravo on 31/01/17.
 */

public interface RegisterCallback {

    void onRegisterResponse(RegisterResponse registerResponse);

    void onRegisterError(ErrorResponse errorResponse);

}
