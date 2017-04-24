package com.github.afterloe;

import com.github.afterloe.inter.BufferedReaderProcess;
import com.github.afterloe.inter.IntPredicate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Predicate;

/**
 * Created by afterloe on 4/24/2017.
 */
public class Demo5 {

    /**
     * 将行为抽离，使用函数式接口进行拓展，环绕执行模式
     *
     * @param bfp
     * @return
     * @throws IOException
     */
    private static String processFile(BufferedReaderProcess bfp) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("E:\\afterloe project\\java\\j28Study\\src\\application.yml"))){
            return bfp.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        String str = processFile((br) -> br.readLine());
        System.out.println(str);
        str = processFile((br) -> br.readLine() + br.readLine());
        System.out.println(str);

        IntPredicate i1 = (i) -> i %2 == 0; // 无封装 int
        /**
         * 形参是基于 上下文绑定的，所以不用显示的定义每个参数的类型
         */
        System.out.println(i1.test(1000));
        /**
         * 当然写上也不是不可以的，建议不要使用封装，因为封装会浪费一层执行
         */
        Predicate<Integer> i2 = (Integer i) -> i%2 == 1; // 有封装 int -> Interger
        System.out.println(i2.test(1003));
    }
}
