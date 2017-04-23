package com.github.afterloe;

import java.util.Collection;
import java.util.HashSet;

import com.github.afterloe.domain.Apple;

public class Demo2 {

	/**
	 * Lambda 重载 AppleUtil::isGreeApple 和  AppleUtil::isHeavyApple
	 */
	public static void main(String[] args) {
		Collection<Apple> __ = new HashSet<Apple>();
		__.add(new Apple(132, "red"));
		__.add(new Apple(150, "gree"));
		__.add(new Apple(155, "red"));
		__.add(new Apple(140, "gree"));
		__.add(new Apple(152, "red"));
		__.add(new Apple(133, "gree"));
		
		/**
		 * 使用Lambda可以更加优雅的编写匿名函数
		 */
		System.out.println(AppleUtil.filterApple(__, (Apple apple) -> "gree".equals(apple.getColor())));
		System.out.println(AppleUtil.filterApple(__, (Apple apple) -> 150 < apple.getWeight()));
	}

}
