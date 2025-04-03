package com.ych.jvm.ch02;

/**
 * <p>
 *     Java虚拟机栈溢出
 *     VM Args：-Xss2M （这时候不妨设大些，请在32位系统下运行）
 *
 *     -Xss
 * </p>
 * @author 杨灿杭
 * @Description
 * @create 2025-04-03 14:53
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("我一直在创建线程");
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
