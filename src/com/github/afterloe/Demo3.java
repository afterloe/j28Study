package com.github.afterloe;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import static java.util.stream.Collectors.toList;

import com.github.afterloe.domain.Apple;

public class Demo3 {

	public static void main(String[] args) {
		/**
		 * Collection��Ҫ��Ϊ�˴洢�ͷ������ݣ���Stream����Ҫ�� �����������ݵļ���
		 */
		Collection<Apple> __ = new HashSet<Apple>();

		__.add(new Apple(132, "red"));
		__.add(new Apple(150, "gree"));
		__.add(new Apple(155, "red"));
		__.add(new Apple(140, "gree"));
		__.add(new Apple(152, "red"));
		__.add(new Apple(133, "gree"));

		/**
		 * ʹ��Stream API ��� Lambda ʹ�ö��ģʽ���������ݴ���(����map-reduce)
		 * 
		 * ת��ΪStream�����в��д���Ȼ����ת����List
		 * 
		 * ˳����
		 */
		List<Apple> heavyApples = __.stream().filter((Apple apple) -> 150 < apple.getWeight()).collect(toList());

		System.out.println(heavyApples);
		
		/**
		 * ���д���
		 */
		List<Apple> colorApples = __.parallelStream().filter((Apple apple) -> "gree".equals(apple.getColor())).collect(toList());
		System.out.println(colorApples);
	}
}
