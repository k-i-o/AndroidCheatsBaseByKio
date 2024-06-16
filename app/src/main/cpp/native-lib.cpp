#include <pthread.h>
#include <jni.h>
#include "Includes/Utils.h"
#include "Substrate/SubstrateHook.h"
#include "KittyMemory/MemoryPatch.h"

extern "C" {
    JNIEXPORT jstring JNICALL
    Java_it_kiocode_il2cppandroidcheats_components_Menu_name(JNIEnv *env, jclass clazz) {
        jstring str = env->NewStringUTF("kiocode");
        return str;
    }
    JNIEXPORT jstring JNICALL
    Java_it_kiocode_il2cppandroidcheats_components_Menu_name2(JNIEnv *env, jclass clazz) {
        jstring str = env->NewStringUTF("kiocode on yt");
        return str;
    }

    const char *libName = "libil2cpp.so";
    struct My_Patches { MemoryPatch; } hexPatches;

    JNIEXPORT jobjectArray JNICALL
    Java_it_kiocode_il2cppandroidcheats_Main_getFeatures(JNIEnv *env, jclass clazz) {
        jobjectArray ret;

        const char *features[] = {
                "page_Visual",
                "page_Aimbot",
                "page_Exploit",

                "BLOCK_0_0,1,2", // 0,1,2

                "switch_9_0_Enable Better Multiplier",
                "switch_11_2_Enable Better Multiplier",
                "slider_10_1_Multiplier_999_100"
        };
        int Total_Feature = (sizeof features / sizeof features[0]);

        ret = (jobjectArray) env->NewObjectArray(Total_Feature, env->FindClass("java/lang/String"), env->NewStringUTF(""));
        int i;
        for (i = 0; i < Total_Feature; i++) {
            env->SetObjectArrayElement(ret, i, env->NewStringUTF(features[i]));
        }
        return (ret);
    }

//    void hexChange(bool &var, MemoryPatch &patch) {
//        var = !var;
//        if (var) {
//            patch.Modify();
//        } else {
//            patch.Restore();
//        }
//    }

    bool betterMultiply=false;
    double (*Projectile__Update)(void *instance);
    double Projectile__Update_h(void *instance) {
        if(instance != NULL) {
           if(betterMultiply) {
              return 0.0;
           }
        }
       return Projectile__Update(instance);
     }

    JNIEXPORT void JNICALL
    Java_it_kiocode_il2cppandroidcheats_Main_ChangesInt(JNIEnv *env, jclass clazz, jint feature, jint value) {
        /*  FEATURES  */
        switch (feature) {
            case 9:
                betterMultiply = value;
                break;
            default:
                break;
        }
    }

    JNIEXPORT void JNICALL
    Java_it_kiocode_il2cppandroidcheats_Main_ChangesBool(JNIEnv *env, jclass clazz, jint feature, jboolean value) {
        /*  FEATURES  */
        switch (feature) {
            case 9:
                betterMultiply = value;
                break;
            default:
                break;
        }
    }

    JNIEXPORT void JNICALL
    Java_it_kiocode_il2cppandroidcheats_MainActivity_OnKeyUp(JNIEnv *env, jclass clazz) {
        betterMultiply = true;
    }

    JNIEXPORT void JNICALL
    Java_it_kiocode_il2cppandroidcheats_MainActivity_OnKeyDown(JNIEnv *env, jclass clazz) {
        betterMultiply = false;
    }

}

// ---------- Hooking ---------- //
void *hack_thread(void *) {

    MSHookFunction((void *) getAbsoluteAddress(libName, 0x8F6D78), (void *)Projectile__Update_h, (void **) &Projectile__Update);

    return NULL;
}

JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM *vm, void *reserved) {
    JNIEnv *globalEnv;
    vm->GetEnv((void **) &globalEnv, JNI_VERSION_1_6);

    pthread_t ptid;
    pthread_create(&ptid, NULL, hack_thread, NULL);

    return JNI_VERSION_1_6;
}

JNIEXPORT void JNICALL
JNI_OnUnload(JavaVM *vm, void *reserved) {}
