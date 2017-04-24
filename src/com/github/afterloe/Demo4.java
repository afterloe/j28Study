package com.github.afterloe;

/**
 * Created by afterloe on 4/24/2017.
 */
public class Demo4 {
    public static void main(String[] args) {
        /**
         * int 值如果在 Lambda 中被使用，则不能再修改。所以建议是用 final 修饰
         */
        final int num = 132;
        Thread thread = new Thread(() -> System.out.println(num));
        thread.start();
    }
}
