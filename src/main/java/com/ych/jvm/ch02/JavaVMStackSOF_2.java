package com.ych.jvm.ch02;

/**
 * <p>
 *     VM Args：-Xss128k
 * </p>
 * @author 杨灿杭
 * @Description
 * @create 2025-04-03 15:04
 */
public class JavaVMStackSOF_2 {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF_2 oom = new JavaVMStackSOF_2();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
