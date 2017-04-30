package com.github.afterloe;

import com.github.afterloe.domain.Dish;
import org.junit.Test;

import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Created by afterloe on 4/30/2017.
 */
public class Demo12 {

    @Test
    /**
     * 汇总 函数使用
     *
     * summingInt summingDouble summingLong 常用的汇总函数
     * averagingInt averagingDouble averagingLong 常用的平均值函数
     */
    public void test() {
        Collection<Dish> menu = Demo7.generatorMenu();
        /**
         * 最大值
         */
        int sumCalories = menu.stream()
                .collect(summingInt(Dish::getCalories));

        System.out.println(sumCalories);

        /**
         * 平均值
         */
        double averagingCalories = menu.stream()
                .collect(averagingInt(Dish::getCalories));

        System.out.println(averagingCalories);

        /**
         * 自动收集所有值
         */
        IntSummaryStatistics summaryStatistics = menu.stream()
                .collect(summarizingInt(Dish::getCalories));

        System.out.println(summaryStatistics);
    }

    @Test
    /**
     * 字符串收集器
     */
    public void test1() {
        Collection<Dish> menu = Demo7.generatorMenu();

        String menuName = menu.stream()
                .map(Dish::getName)
                .collect(joining(" "));

        System.out.println(menuName);
    }

    @Test
    /**
     * reducing 自定义收集器
     *
     * collect 中用 reducing方法，接受三个参数
     *
     * 1.初始值
     * 2.每个调用的函数
     * 3.reduce逻辑
     */
    public void test2() {
        Collection<Dish> menu = Demo7.generatorMenu();

        int sumCalories = menu.stream()
                .collect(reducing(0, Dish::getCalories, (i, j) -> i + j));

        System.out.println(sumCalories);
    }
}
