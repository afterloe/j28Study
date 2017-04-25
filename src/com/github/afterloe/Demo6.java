package com.github.afterloe;

import java.util.function.Function;

/**
 * Created by afterloe on 4/25/2017.
 */
public class Demo6 {
    /**
     * Lambda 组合 andThen、compose 使用这两种就可以组合生成函数的流水线
     */
    static Function<Integer, Integer> add = x -> x + 1;
    static Function<Integer, Integer> multiplication = x -> x * 2;

    public static void main(String[] args) {
        // 先加法 然后 乘法 Lambda 组合 从左先开始
        Function<Integer, Integer> andThen = Demo6.add.andThen(Demo6.multiplication);

        // 先乘法 然后加法 Lambda 组合 从右先开始
        Function<Integer, Integer> compose = Demo6.add.compose(Demo6.multiplication);

        System.out.println(andThen.apply(3)); // 8
        System.out.println(compose.apply(3)); // 7
    }
}
