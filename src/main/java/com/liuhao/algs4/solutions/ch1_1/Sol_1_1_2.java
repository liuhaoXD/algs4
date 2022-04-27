package com.liuhao.algs4.solutions.ch1_1;

public class Sol_1_1_2 {

    public static void main(String[] args) {
        // a. int 与 double 运算时，会自动进行类型转换，因此 3.236 / 2 ==> 1.618
        System.out.println((1 + 2.236) / 2);

        // b. 同上 6 + 4.0 ==> 10.0
        System.out.println(1 + 2 + 3 + 4.0);

        // c. 由于 IEEE 754 表示存在精度损失，在 double 运算中使用 "==" 操作可能会出问题，只能使用 >、< 不等式运算符
        System.out.println(4.1 >= 4);

        // d. 数字与字符串运算时，会自动转换为字符串，第一个 + 是数值运算，第二个 + 是字符串拼接
        // 3 + "3" ==> "33"
        System.out.println(1 + 2 + "3");
    }

}
