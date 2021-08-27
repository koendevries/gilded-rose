package com.gildedrose.util;

import com.gildedrose.Item;

public class ParameterizedTestData {
    public final Item item;
    public final int expected;

    public ParameterizedTestData(Item item, int expected) {
        this.item = item;
        this.expected = expected;
    }
}
