JavaQueryThreadClockCycles
==========================

A simple Java JNI implementation that gives high-accuracy per-thread CPU cycle information.

The native implementations are released to the public domain.  This implementation has a dependency on the MIT-licensed com.wapmx.native.mx-native-loader but this can be removed

Includes native implementations for Linux and for Windows.

Important implementation note:
  Windows - calls QueryThreadCycleTime, returns number of CPU cycles
  Linux - calls clock_gettime passing CLOCK_THREAD_CPUTIME_ID, returns time in nanoseconds that this thread has spent executing on CPU

To rebuild the packaged native libraries, navigate to src/main/native and invoke:
  Windows - win32/build.bat
  Linux - linux/build.sh


