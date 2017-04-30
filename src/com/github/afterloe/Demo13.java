package com.github.afterloe;

import com.github.afterloe.domain.Dish;
import com.github.afterloe.enums.Type;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by afterloe on 4/30/2017.
 */
public class Demo13 {

    @Test
    /**
     * 输出菜单按照类型分类
     */
    public void test() {
        Collection<Dish> menu = Demo7.generatorMenu();

        Map<Type, List<Dish>> menuMap = menu.stream()
                .collect(groupingBy(Dish::getType));

        System.out.println(menuMap);
    }
}
