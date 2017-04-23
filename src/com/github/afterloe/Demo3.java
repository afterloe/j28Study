package com.github.afterloe;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import static java.util.stream.Collectors.toList;

import com.github.afterloe.domain.Apple;

public class Demo3 {

	public static void main(String[] args) {
		/**
		 * Collection主要是为了存储和访问数据，而Stream则主要用 于描述对数据的计算
		 */
		Collection<Apple> __ = new HashSet<Apple>();

		__.add(new Apple(132, "red"));
		__.add(new Apple(150, "gree"));
		__.add(new Apple(155, "red"));
		__.add(new Apple(140, "gree"));
		__.add(new Apple(152, "red"));
		__.add(new Apple(133, "gree"));

		/**
		 * 使用Stream API 配合 Lambda 使用多核模式来进行数据处理(类似map-reduce)
		 * 
		 * 转换为Stream，进行并行处理，然后再转换回List
		 * 
		 * 顺序处理
		 */
		List<Apple> heavyApples = __.stream().filter((Apple apple) -> 150 < apple.getWeight()).collect(toList());

		System.out.println(heavyApples);
		
		/**
		 * 并行处理
		 */
		List<Apple> colorApples = __.parallelStream().filter((Apple apple) -> "gree".equals(apple.getColor())).collect(toList());
		System.out.println(colorApples);
	}
}
