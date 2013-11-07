#include <jni.h>
#include <stdio.h>
#include <time.h>
#include "../ThreadCPUTimer.h"
 
struct timespec tp;
JNIEXPORT jlong JNICALL Java_edu_brown_cs_systems_clockcycles_CPUCycles_getNative(JNIEnv *, jclass) {
   clock_gettime(CLOCK_THREAD_CPUTIME_ID, &tp);
   return tp.tv_sec * 1000000000 + tp.tv_nsec;
}
