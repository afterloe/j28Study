package com.github.afterloe;

import com.github.afterloe.domain.Dish;
import com.github.afterloe.enums.Type;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

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
}
