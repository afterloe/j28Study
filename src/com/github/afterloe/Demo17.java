package com.github.afterloe;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * Created by afterloe on 5/2/2017.
 *
 * 使用分支/合并框架并行求和
 */
public class Demo17 {

    private class ToRunning extends RecursiveTask<Long> {

        private final long[] numbers;
        private final int start;
        private final int end;

        public static final long THRESHOLD = 10000;

        public ToRunning(long[] numbers) {
            this(numbers, 0, numbers.length);
        }

        private ToRunning(long[] numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            int length = end -start;
            if (length <= THRESHOLD) return computeSequentially();

            ToRunning leftTask = new ToRunning(numbers, start, start + length / 2);
            leftTask.fork();
            ToRunning rightTask = new ToRunning(numbers, start + length /2 , end);
            Long rightResult = rightTask.compute();
            Long leftResult = leftTask.join();

            return rightResult + leftResult;
        }

        private long computeSequentially() {
            long sum = 0;
            for (int i = start; i < end; i++) sum += numbers[i];

            return sum;
        }
    }

    @Test
    public void test() {
        long[] numbers = LongStream.rangeClosed(1l, 100000).toArray();

        ToRunning task = new ToRunning(numbers);
        long sum = new ForkJoinPool().invoke(task);
        System.out.println(sum);
    }
}

