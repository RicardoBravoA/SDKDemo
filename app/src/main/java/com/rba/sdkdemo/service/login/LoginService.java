package com.rba.sdkdemo.service.login;

import com.rba.sdkdemo.api.ErrorUtil;
import com.rba.sdkdemo.api.StoreApiManager;
import com.rba.sdkdemo.model.request.LoginRequest;
import com.rba.sdkdemo.model.response.ErrorResponse;
import com.rba.sdkdemo.model.response.LoginResponse;
import com.rba.sdkdemo.util.SDKConstant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ricardo Bravo on 30/01/17.
 */

public class LoginService {

    public static void login(LoginRequest loginRequest, final LoginCallback callback){

        Call<LoginResponse> call = StoreApiManager.apiManager().login(SDKConstant.LOGIN_URL, loginRequest);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    callback.onLoginResponse(response.body());
                }else{
                    callback.onLoginError(ErrorUtil.parseError(response));
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                ErrorResponse errorResponse = new ErrorResponse();
                ErrorResponse.MetaBean metaBean = new ErrorResponse.MetaBean();
                metaBean.setMessage(t.getMessage());
                errorResponse.set_meta(metaBean);
                callback.onLoginError(errorResponse);
            }
        });

    }

}
