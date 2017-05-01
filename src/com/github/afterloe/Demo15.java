package com.github.afterloe;

import com.github.afterloe.domain.Dish;
import org.junit.Test;

import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

/**
 * Created by afterloe on 5/1/2017.
 */
public class Demo15 {

    @Test
    /**
     * 分区的运用
     *
     * 由一个谓词作为分类函数，它称分区函数, 分区函数返回一个布尔值，得到的分组Map的键类型是Boolean
     * 分为两组——true是一组， false是一组
     */
    public void test() {
        Collection<Dish> menu = Demo7.generatorMenu();

        Map<Boolean, Collection<Dish>> partitionedMenu = menu.stream()
                .collect(partitioningBy(
                        Dish::isVegetarian, toCollection(HashSet::new)
                ));

        System.out.println(partitionedMenu);
    }

    @Test
    /**
     * 区分是否是素食 并得到最高卡路里的食物
     */
    public void test1() {
        Collection<Dish> menu = Demo7.generatorMenu();

        Map<Boolean, Dish> maxDish = menu.stream().collect(partitioningBy(
                        Dish::isVegetarian,
                        collectingAndThen(
                                maxBy(comparingInt(Dish::getCalories)),
                                Optional::get
                        )
                ));

        System.out.println(maxDish);
    }
}
