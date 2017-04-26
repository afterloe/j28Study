package com.github.afterloe;

import com.github.afterloe.domain.Dish;
import com.github.afterloe.enums.Type;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

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
}
