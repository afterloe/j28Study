package com.github.afterloe;

import com.github.afterloe.domain.Dish;
import com.github.afterloe.enums.Type;
import org.junit.Test;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

/**
 * Created by afterloe on 5/1/2017.
 */
public class Demo14 {

    @Test
    /**
     * 多级分组 演示
     */
    public void test() {
        Collection<Dish> menu = Demo7.generatorMenu();

        Map<Type, Map<String, List<Dish>>> dishesByTypeCaloricLevel = menu.stream()
                .collect(
                        /**
                         * 一级分组 先 按照 菜单类型进行排序
                         */
                        groupingBy(Dish::getType,
                                /**
                                 * 二级分组 安装热量分组
                                 */
                                groupingBy(dish -> {
                                    // 自定义分组
                                    if (dish.getCalories() < 400) {
                                        return "低热量";
                                    } else if (dish.getCalories() >= 400 && dish.getCalories() < 600) {
                                        return "中等热量";
                                    }
                                    return "高热量";
                                })
                        )
                );

        System.out.println(dishesByTypeCaloricLevel);
    }

    @Test
    /**
     * 输出 每种类型的菜有多少个
     */
    public void test1() {
        Collection<Dish> menu = Demo7.generatorMenu();

        Map<Type, Long> typeCount = menu.stream()
                /**
                 * grouping 函数 第二个不一定是 grouping 函数，也可以是其他的函数
                 */
                .collect(groupingBy(Dish::getType, counting()));

        System.out.println(typeCount);
    }

    @Test
    /**
     * 转换收集器结果
     */
    public void test2() {
        Collection<Dish> menu = Demo7.generatorMenu();

        Map<Type, Dish> typeDishMap = menu.stream()
                /**
                 * groupingBy收集器包裹着collectingAndThen收集器，
                 * 因此分组操作得到的每个子流都用这第二个收集器做进一步归约
                 */
                .collect(groupingBy(Dish::getType,
                        /**
                         * 工厂方法 接受两个参数 转换的收集器 转换函数
                         */
                        collectingAndThen(
                                maxBy(comparingInt(Dish::getCalories)),
                                /**
                                 * collectingAndThen收集器会对 其结果应用Optional:get转换函数
                                 * 从 optional 中获取值
                                 */
                                Optional::get)));

        System.out.println(typeDishMap);
    }

    @Test
    /**
     * groupingBy 联合使用的其他收集器的 例子
     */
    public void test3() {
        
    }
}
