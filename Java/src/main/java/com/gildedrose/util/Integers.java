package com.gildedrose.util;

import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class Integers {

    private Integers() {
    }

    public static <T> ToIntFunction<T> constant(int amount) {
        return t -> amount;
    }

    public static <T> ToIntFunction<T> where(
            Predicate<T> condition,
            ToIntFunction<T> matched,
            ToIntFunction<T> otherwise) {
        return t -> condition.test(t)
                ? matched.applyAsInt(t)
                : otherwise.applyAsInt(t);
    }

}
