package com.github.afterloe;

import com.github.afterloe.domain.Traders;
import com.github.afterloe.domain.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Created by afterloe on 4/27/2017.
 */
public class Demo9 {

    Traders afterloe;
    Traders joe;
    Traders kimi;
    Traders namo;

    Collection<Transaction> transactions;

    @Before
    public void initEnv() {
        afterloe = new Traders("afterloe liu", "太子港");
        joe = new Traders("joe cao", "花莲市");
        kimi = new Traders("kimi lin", "陆家嘴");
        namo = new Traders("namo zhou", "太子港");

        transactions = Arrays.asList(
                new Transaction(afterloe, 2015, 80500),
                new Transaction(afterloe, 2016, 50040),
                new Transaction(afterloe, 2017, 120000),
                new Transaction(joe, 2015, 63000),
                new Transaction(joe, 2016, 66000),
                new Transaction(joe, 2017, 42000),
                new Transaction(kimi, 2015, 120000),
                new Transaction(kimi, 2016, 185050),
                new Transaction(kimi, 2017, 146000),
                new Transaction(namo, 2015, 68000),
                new Transaction(namo, 2016, 96000),
                new Transaction(namo, 2017, 120000)
        );
    };

    @Test
    public void test() {
        // 找出 2015 年所有的交易并按照交易额度进行排序 从低到高排序
        Collection<Transaction> tr1 = transactions.stream()
                .filter(t -> 2015 == t.getYear())
                .sorted(comparing(Transaction::getValue))
                .collect(toList());

        System.out.println(tr1);
    }

    @Test
    public void test1() {
        // 找出交易员都在哪些城市工作过
        Collection<String> cities = transactions.stream()
                .map(t -> t.getTraders().getCity())
                .distinct()
                .collect(toList());

        System.out.println(cities);
    }

    @Test
    public void test2() {
        // 找出所有 太子港 的员工，并按照姓名排序
        Collection<Traders> users = transactions.stream()
                .map(t -> t.getTraders())
                .filter(t -> "太子港".equals(t.getCity()))
                .distinct()
                .sorted(comparing(Traders::getName))
                .collect(toList());

        System.out.println(users);
    }

    @Test
    public void test3() {
        // 返回所有交易员的姓名字符串并按照字母排序
        String usersWords = transactions.stream()
                .map(transaction -> transaction.getTraders().getName())
                .sorted()
                .distinct()
                .reduce((x,y) -> x + y).orElse("");

        System.out.println(usersWords);
    }

    @Test
    public void test3_1() {
        String usersWords = transactions.stream()
                .map(transaction -> transaction.getTraders().getName())
                .distinct()
                .sorted()
                .collect(joining());

        System.out.println(usersWords);
    }

    @Test
    public void test4() {
        // 有没有员工在 太子港 工作的
        boolean isWorking = transactions.stream()
                .anyMatch(transaction -> transaction.getTraders().getCity().equals("太子港"));

        System.out.println(isWorking);
    }

    @Test
    public void test5() {
        // 输出 太子港的所有业绩
        double sum = transactions.stream()
                .filter(transaction -> "太子港".equals(transaction.getTraders().getCity()))
                .map(Transaction::getValue)
                .reduce(Float::sum).orElse(0f);

        System.out.println(sum);
    }

    @Test
    public void test6() {
        // 输出 最高的交易额
        double max = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Float::max)
                .orElse(0f);

        System.out.println(max);
    }

    @Test
    public void test7() {
        // 找出交易额最小的交易
        Transaction transaction = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1: t2)
                .orElse(null);

        System.out.println(transaction);
    }
}
