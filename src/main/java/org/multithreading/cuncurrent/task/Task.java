package org.multithreading.cuncurrent.task;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Task {

    public static void main(String[] args) {
        int[] values = new int[100_000_000];
        Random random = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] =  random.nextInt(300) + 1;
        }

        trackTime(() -> findMax(values));
        trackTime(() -> findMaxParallel(values));

    }

    private static int trackTime(Supplier<Integer> task){
        long startTime = System.currentTimeMillis();
        int result = task.get();
        System.out.println(result + ": " + (System.currentTimeMillis() - startTime));
        return result;
    }

    private static int findMax(int[] values){
        return IntStream.of(values)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    private static int findMaxParallel(int[] values){
        return IntStream.of(values)
                .parallel()
                .max()
                .orElse(Integer.MIN_VALUE);
    }
}
