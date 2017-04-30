package com.github.afterloe;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by afterloe on 4/30/2017.
 */
public class Demo11 {

    @Test
    /**
     * 计算一个文化中 有多少个 不相同的词
     */
    public void test() {
        long uniqueWords = 0;
        // 使用Files.lines得到一个流，其中的每个元素都是给定文件中的一行。
        try (Stream<String> fileLine = Files.lines(Paths.get("E:\\afterloe project\\java\\j28Study\\src\\com\\github\\afterloe\\Demo7.java"), Charset.defaultCharset())){
            uniqueWords = fileLine.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();

            System.out.println(uniqueWords);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Test
    /**
     * 斐波那契数 运用
     */
    public void test1() {
        // 使用无限流扩展 输出20个斐波那契数
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
    }

    @Test
    public void test2() {
        // 生成输出随机数
        Stream.generate(Math::random)
                .limit(500)
                .forEach(System.out::println);
    }
}
