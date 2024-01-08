package com.liuhao.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * 两个或多个线程交替打印数字
 * 我们使用 volatile 变量代替 CAS 变量，减轻使用 CAS 的消耗，注意，这里 ++num 不是原子的，但不妨碍，因为有 flag 变量控制。
 * 而 num 必须是 volatile 的，如果不是，会导致可见性问题。
 */
public class ConcurrentPrint4 {
    private List<Observer> list = new ArrayList<Observer>();

    public static void main(String[] args) {

    }
}
