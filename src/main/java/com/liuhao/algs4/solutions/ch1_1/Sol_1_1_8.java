package com.liuhao.algs4.solutions.ch1_1;

public class Sol_1_1_8 {

    public static void a() {
        // 输出 "b"，char 会转换为 string
        System.out.println('b');
    }

    public static void b() {
        // 输出 int('b') + int('c')，两个 char 通过加法运算后转换为了数字，再转换为 string
        System.out.println('b' + 'c');
    }

    public static void c() {
        // 输出 "e"，数字通过强制类型转换得到 char，char 打印时隐式转换为 string
        System.out.println((char) ('a' + 4));
    }


    public static void main(String[] args) {
        a();
        b();
        c();
    }
}
