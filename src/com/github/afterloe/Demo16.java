package com.github.afterloe;

import org.junit.Test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by afterloe on 5/2/2017.
 */
public class Demo16 {

    @Test
    public void test() {
        long maxSum = Stream
                .iterate(1l, i -> i + 1)
                .limit(30000)
                .parallel()
                .reduce(0l, Long::sum);

        System.out.println(maxSum);
    }

    /**
     * 高效率并行流
     */
    @Test
    public void test1() {
        long maxSum = LongStream.rangeClosed(1, 10000000)
                .parallel()
                .reduce(0l, Long::sum);

        System.out.println(maxSum);
    }
}
