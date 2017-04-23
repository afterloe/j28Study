package com.github.afterloe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

import com.github.afterloe.domain.Apple;

class AppleUtil {

	/**
	 * 假设你有一个Apple类，它有一个getColor方法，还有一个变量inventory保存着一个Apples的列表。你可能想要选出所
	 * 有的绿苹果，并返回一个列表。通常我们用筛选（filter）一词来表达这个概念。把条件代码作为参数传递进去，这样可以避免filter方法
	 * 出现重复的代码。
	 */
	public static boolean isGreeApple(Apple apple) {
		return "gree".equals(apple.getColor());
	}

	public static boolean isHeavyApple(Apple apple) {
		return 150 < apple.getWeight();
	}

	/**
	 * 方 法 作 为 Predicate参数p传递进去方 法 Apple::isGreenApple （ 它 接 受 参 数 Apple 并 返 回 一
	 * 个 boolean）给filterApples，后者则希望接受一个Predicate<Apple>参数。谓词 （predicate）
	 * 在数学上常常用来代表一个类似函数的东西，它接受一个参数值，并返回true或false。
	 */
	public static Collection<Apple> filterApple(Collection<Apple> inventory, Predicate<Apple> function) {
		Collection<Apple> __ = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			// 符 合 function 所 代表的条件
			if (function.test(apple)) {
				__.add(apple);
			}
		}
		return __;
	};
}

public class Demo1 {

	/**
	 * 测试
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
