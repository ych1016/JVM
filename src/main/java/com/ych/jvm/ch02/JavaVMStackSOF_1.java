package com.ych.jvm.ch02;

/**
 * <p>
 *     VM Args：-Xss128k
 * </p>
 * @author 杨灿杭
 * @Description
 * @create 2025-04-03 15:01
 */
public class JavaVMStackSOF_1 {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF_1 oom = new JavaVMStackSOF_1();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
