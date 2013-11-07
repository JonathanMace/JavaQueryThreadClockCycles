#include <jni.h>
#include "ThreadCPUTimer.h"
#include <Windows.h>

LONG64 cycles;
JNIEXPORT jlong JNICALL Java_edu_brown_cs_systems_clockcycles_CPUCycles_getNative(JNIEnv *env, jclass thisObj) {
	QueryThreadCycleTime(GetCurrentThread(), &cycles); 
	return cycles;
}
