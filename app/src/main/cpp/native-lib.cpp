#include <jni.h>
#include <string>

//声明结构体
typedef struct {
    uint8_t blue;
    uint8_t green;
    uint8_t red;
    uint8_t alpha;
} Channels;

typedef union {
    int32_t color;
    Channels channels;
} Color;

extern "C"
JNIEXPORT jintArray JNICALL
Java_com_xhz_helloc_MainActivity_getChannel(JNIEnv *env, jobject instance, jint color) {

//创建联合体
    Color c;
    c.color=color;
    jint buf[4];
    buf[0]=c.channels.alpha;
    buf[1]=c.channels.red;
    buf[2]=c.channels.green;
    buf[3]=c.channels.blue;
    jintArray  arr=env->NewIntArray(4);
    env->SetIntArrayRegion(arr,0,4, buf);
    return arr;
}




