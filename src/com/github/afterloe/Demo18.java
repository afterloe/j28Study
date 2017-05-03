package com.github.afterloe;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;

/**
 * Created by afterloe on 5/3/2017.
 */
public class Demo18 {

    @Test
    public void test() {
        BigDecimal x = new BigDecimal("0.97");
        for (int i = 0; i < 11; i++) {
            x = x.multiply(x);
            System.out.println(new BigDecimal("1").subtract(x));
        }

        System.out.println(x);
    }
}
