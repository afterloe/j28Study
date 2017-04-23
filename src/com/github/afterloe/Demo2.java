package com.github.afterloe;

import java.util.Collection;
import java.util.HashSet;

import com.github.afterloe.domain.Apple;

public class Demo2 {

	/**
	 * Lambda ���� AppleUtil::isGreeApple ��  AppleUtil::isHeavyApple
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
		 * ʹ��Lambda���Ը������ŵı�д��������
		 */
		System.out.println(AppleUtil.filterApple(__, (Apple apple) -> "gree".equals(apple.getColor())));
		System.out.println(AppleUtil.filterApple(__, (Apple apple) -> 150 < apple.getWeight()));
	}

}
