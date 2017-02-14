#include <jni.h>
#include <string>

extern "C"
jstring
Java_com_rba_sdkdemo_util_SDKConstant_stringBaseUrl(
        JNIEnv *env,
        jobject) {
    std::string url = "http://172.18.60.67:8888/StoreApi/v1/";
    return env->NewStringUTF(url.c_str());
}

jstring
Java_com_rba_sdkdemo_util_SDKConstant_stringLoginUrl(
        JNIEnv *env,
        jobject) {
    std::string url = "login/";
    return env->NewStringUTF(url.c_str());
}

jstring
Java_com_rba_sdkdemo_util_SDKConstant_stringRegisterUrl(
        JNIEnv *env,
        jobject) {
    std::string url = "register/";
    return env->NewStringUTF(url.c_str());
}
