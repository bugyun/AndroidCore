#include <jni.h>
#include <string>

extern "C"

JNIEXPORT jstring JNICALL
Java_com_finupgroup_androidcore_code_NativeCpp_stringFromJNI(JNIEnv *env, jobject instance) {
    std::string hello = "Hello from NativeCpp C++";
    return env->NewStringUTF(hello.c_str());
}

JNIEXPORT jstring JNICALL
Java_com_finupgroup_androidcore_MainActivity_stringFromJNI(JNIEnv *env, jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
