package com.github.afterloe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

import com.github.afterloe.domain.Apple;

class AppleUtil {

	/**
	 * ��������һ��Apple�࣬����һ��getColor����������һ������inventory������һ��Apples���б��������Ҫѡ����
	 * �е���ƻ����������һ���б�ͨ��������ɸѡ��filter��һ�������������������������Ϊ�������ݽ�ȥ���������Ա���filter����
	 * �����ظ��Ĵ��롣
	 */
	public static boolean isGreeApple(Apple apple) {
		return "gree".equals(apple.getColor());
	}

	public static boolean isHeavyApple(Apple apple) {
		return 150 < apple.getWeight();
	}

	/**
	 * �� �� �� Ϊ Predicate����p���ݽ�ȥ�� �� Apple::isGreenApple �� �� �� �� �� �� Apple �� �� �� һ
	 * �� boolean����filterApples��������ϣ������һ��Predicate<Apple>������ν�� ��predicate��
	 * ����ѧ�ϳ�����������һ�����ƺ����Ķ�����������һ������ֵ��������true��false��
	 */
	public static Collection<Apple> filterApple(Collection<Apple> inventory, Predicate<Apple> function) {
		Collection<Apple> __ = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			// �� �� function �� ���������
			if (function.test(apple)) {
				__.add(apple);
			}
		}
		return __;
	};
}

public class Demo1 {

	/**
	 * ����
	 */
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
