package com.ych.jvm.ch02;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     堆溢出
 *     VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 *     -Xms20m： 设置 Java 堆（Heap）初始大小为 20MB。
 *     -Xmx20m： 设置 Java 堆的最大大小为 20MB。
 *     -XX:+HeapDumpOnOutOfMemoryError： 当发生 OOM 时，生成堆转储（Heap Dump）文件。
 * </p>
 *
 * @author 杨灿杭
 * @Description
 * @create 2025-04-03 14:20
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        // 通过jvm参数限定堆大小，再通过不断创建对象使得堆溢出
        while (true) {
            list.add(new OOMObject());
        }
    }
}
