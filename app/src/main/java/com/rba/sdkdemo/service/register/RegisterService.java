package com.rba.sdkdemo.service.register;

import com.rba.sdkdemo.api.ErrorUtil;
import com.rba.sdkdemo.api.StoreApiManager;
import com.rba.sdkdemo.model.request.RegisterRequest;
import com.rba.sdkdemo.model.response.ErrorResponse;
import com.rba.sdkdemo.model.response.RegisterResponse;
import com.rba.sdkdemo.util.SDKConstant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ricardo Bravo on 31/01/17.
 */

public class RegisterService {

    public static void register(RegisterRequest registerRequest, final RegisterCallback callback){

        Call<RegisterResponse> call = StoreApiManager.apiManager().register(SDKConstant.REGISTER_URL,
                registerRequest);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if(response.isSuccessful()){
                    callback.onRegisterResponse(response.body());
                }else{
                    callback.onRegisterError(ErrorUtil.parseError(response));
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                ErrorResponse errorResponse = new ErrorResponse();
                ErrorResponse.MetaBean metaBean = new ErrorResponse.MetaBean();
                metaBean.setCode("1000");
                metaBean.setMessage(t.getMessage());
                metaBean.setStatus("500");
                errorResponse.set_meta(metaBean);
                callback.onRegisterError(errorResponse);
            }
        });

    }

}
