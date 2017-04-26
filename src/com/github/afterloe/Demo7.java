package com.github.afterloe;

import com.github.afterloe.domain.Dish;
import com.github.afterloe.enums.Type;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by afterloe on 4/26/2017.
 */
public class Demo7 {

    static Collection<Dish> generatorMenu() {
        Collection<Dish> menu = new ArrayList<Dish>();
        menu.add(new Dish("pork", false, 800, Type.MEAT));
        menu.add(new Dish("beef", false, 700, Type.MEAT));
        menu.add(new Dish("chicken", false, 400, Type.MEAT));
        menu.add(new Dish("french fries", true, 530, Type.OTHER));
        menu.add(new Dish("rice", true, 350, Type.OTHER));
        menu.add(new Dish("season fruit", true, 120, Type.OTHER));
        menu.add(new Dish("pizza", true, 550, Type.OTHER));
        menu.add(new Dish("prawns", false, 300, Type.FISH));
        menu.add(new Dish("salmon", false, 450, Type.FISH));
        menu.add(new Dish("dumplings", false, 600, Type.OTHER));
        menu.add(new Dish("salad", true, 210, Type.FRUITS));
        menu.add(new Dish("rice-pudding", false, 400, Type.OTHER));
        menu.add(new Dish("pig", false, 900, Type.MEAT));

        return menu;
    }

    @Test
    public void streamAPIDemon() {
        // 获取菜单
        Collection<Dish> menu = Demo7.generatorMenu();

        // 获取能量小于500 的菜谱的名字 并选出 前三
        Collection<String> threeHighCaloricDishNames = menu.stream()
                .filter(d -> d.getCalories() < 500)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());

        System.out.println(threeHighCaloricDishNames);
    }

    @Test
    public void steamAPIDemo2(){
        /**
         * Stream 中的 终端操作 流只能消费一次的! 切记
         */
        Collection<String> title = Arrays.asList("afterloe", "joe", "sheldon", "grace", "yangyangyang");
        Stream<String> stream = title.stream();
        stream.forEach(System.out::println);
    }

    @Test
    public void streamAPIDemo3() {
        /**
         * 跳过元素
         */
        Collection<Dish> menu = Demo7.generatorMenu();

        // 跳过 2个元素
        Collection<Dish> dishes = menu.stream()
                .filter(d -> d.isVegetarian())
                .skip(2)
                .collect(toList());

        System.out.println(dishes);
    }

    @Test
    public void streamAPIDemo4() {
        /**
         * 使用map 进行映射 将集合中的一个元素进行消费，转换成其他的类型的元素
         */
        Collection<Dish> menu = Demo7.generatorMenu();

        Collection<Integer> list = menu.stream()
                .map(Dish::getCalories)
                .distinct()
                .collect(toList());

        System.out.println(list);
    }

    @Test
    public void streamAPIDemo5() {
        /**
         * flatMap + Array.stream 来进行 流的扁平化管理
         *
         * flatMap 方法的效果是 各个数组分别映射成一个流的内容并用把生成的单个流聚合起来
         */
        Collection<String> words = Arrays.asList("afterloe", "joe", "sheldon", "grace", "yangyangyang");
        Collection<String> uniqueCharacters = words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

        System.out.println(uniqueCharacters);
    }

    @Test
    public void streamAPIDemo6() {
        Collection<Integer> keys = Arrays.asList(1,2,5,7,10,13,15);
        Collection<Integer> value = keys.stream()
                .map(x -> x * x)
                .collect(toList());

        System.out.println(value);
    }

    @Test
    public void streamAPIDemo7() {
        Collection<Integer> a = Arrays.asList(1,2,3);
        Collection<Integer> b = Arrays.asList(3,4);

        Collection<int[]> value = a.stream()
                .flatMap(i -> b.stream().map(j -> new int[]{i,j}))
                .collect(toList());

        value.stream().forEach(i -> System.out.println(Arrays.toString(i)));
    }

    @Test
    public void streamAPIDemo8() {
        Collection<Integer> a = Arrays.asList(1,2,3);
        Collection<Integer> b = Arrays.asList(3,4);

        Collection<int[]> value = a.stream()
                .flatMap(i -> b.stream()
                        .filter(j -> 0 == (i + j) % 3)
                        .map(j -> new int[] {i, j}))
                .collect(toList());

        value.stream().forEach(i -> System.out.println(Arrays.toString(i)));
    }
}
