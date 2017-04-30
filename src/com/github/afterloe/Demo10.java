package com.github.afterloe;

import com.github.afterloe.domain.Dish;
import org.junit.Test;

import java.util.Collection;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by afterloe on 4/30/2017.
 *
 * 数值流 探究
 */
public class Demo10 {

    @Test
    /**
     * 数值流转换  非Integer 处理成 int 原始类型流特化
     */
    public void test() {
        Collection<Dish> menu = Demo7.generatorMenu();
        int allCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        System.out.println(allCalories);

        /**
         * 返包装 基础类型 转 对象类属性

        Stream<Integer> option = menu.stream()
                .mapToInt(Dish::getCalories)
                .boxed();
         */
    }

    @Test
    /**
     * 求解 菜单中 最大的 卡路里的值
     */
    public void tes1() {
        Collection<Dish> menu = Demo7.generatorMenu();
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        // 使用 orElse 防止出现 空指针异常
        System.out.println(maxCalories.orElse(0));
    }

    @Test
    /**
     * 求解 数值范围的 随机数
     */
    public void test2() {
        IntStream evenNumbers = IntStream.rangeClosed(0, 300)
                .filter(n -> 0 == n % 2);

        System.out.println(evenNumbers.count()); // 0 到 300 之间有多少个 偶数
    }
}
