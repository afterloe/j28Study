package com.github.afterloe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

import com.github.afterloe.domain.Apple;

class AppleUtil {
	
	public static boolean isGreeApple(Apple apple) {
		return "gree".equals(apple.getColor());
	}
	
	public static boolean isHeavyApple(Apple apple) {
		return 150 < apple.getWeight();
	}
	
	public static Collection<Apple> filterApple(Collection<Apple> inventory, Predicate<Apple> function) {
		Collection<Apple> __ = new ArrayList<Apple>();
		for (Apple apple: inventory) {
			if (function.test(apple)) {
				__.add(apple);
			}
		}
		return __;
	};
}

public class Demo1 {

	public static void main(String[] args) {
		Collection<Apple> __ = new HashSet<Apple>();
		__.add(new Apple(132, "red"));
		__.add(new Apple(150, "gree"));
		__.add(new Apple(155, "red"));
		__.add(new Apple(140, "gree"));
		__.add(new Apple(152, "red"));
		__.add(new Apple(133, "gree"));
		
		System.out.println(AppleUtil.filterApple(__, AppleUtil::isGreeApple));
		System.out.println(AppleUtil.filterApple(__, AppleUtil::isHeavyApple));
	}

}
