package com.github.afterloe;

import com.github.afterloe.domain.Dish;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by afterloe on 4/27/2017.
 */
public class Demo8 {

    @Test
    public void testFindAny() {
        Collection<Dish> menu = Demo7.generatorMenu();

        Optional<Dish> any = menu.stream()
                .filter(d -> 200 > d.getCalories())
                .findAny();

        System.out.println(any.isPresent()); // 是否包含值
        any.ifPresent(d -> System.out.println(d.getName())); // 如果值存在 则会执行 Lambda中的代码
        System.out.println(any.orElse(null)); // 获取值 如果值不存在则会输出一个默认值
        System.out.println(any.get()); // 获取值 如果不存在会报错
    }

    @Test
    public void testReduce() {
        Collection<Integer> numbers = Arrays.asList(1,3,4,5,6,7,98,9,3,21,2,5,23,5);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);

        System.out.println(sum);
    }

    @Test
    public void testReduce2() {
        Collection<Integer> numbers = Arrays.asList(1,3,4,5,6,7,98,9,3,21,2,5,23,5);
        int sum = numbers.stream().reduce(0, Integer::sum); // 或 使用静态方法

        System.out.println(sum);
    }
}
