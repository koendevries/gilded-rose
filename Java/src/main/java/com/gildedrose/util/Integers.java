package com.gildedrose.util;

import java.util.function.IntPredicate;
import java.util.function.ToIntFunction;

public class Integers {

    private Integers() {
    }

    public static IntPredicate negative() {
        return i -> i < 0;
    }

    public static <T> ToIntFunction<T> stable() {
        return t -> 0;
    }

    public static <T> ToIntFunction<T> increase(int amount) {
        return t -> amount;
    }

    public static <T> ToIntFunction<T> decrease(int amount) {
        return t -> amount * -1;
    }

}
