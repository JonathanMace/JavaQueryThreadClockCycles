package edu.brown.cs.systems.clockcycles;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

import com.wapmx.nativeutils.jniloader.NativeLoader;

public class CPUCycles {

  private static final ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
  private static final boolean linked;
  static {
    boolean success = false;
    try {
      NativeLoader.loadLibrary("threadcputimer");
      getNative(); // test get to make sure it works
      success = true;
    } catch (Throwable e) {
    }
    linked = success;
  }

  /**
   * Returns the thread cycle timer for the current thread.  If possible, delegates this call to a native method,
   * which will give a much higher accuracy than calling the MXBean method. 
   * @return
   */
  public static long get() {
    if (linked)
      return getNative();
    else
      return getJava();
  }

  /**
   * Calls the system high resolution thread cycle timer if supported
   * 
   * @return thread cpu time in nanoseconds
   */
  static native long getNative();

  /**
   * Calls the java thread cycle timer implementation. Is usually pretty crap
   * 
   * @return thread cpu time in nanoseconds
   */
  static long getJava() {
    return mxBean.getCurrentThreadCpuTime();
  }

}
