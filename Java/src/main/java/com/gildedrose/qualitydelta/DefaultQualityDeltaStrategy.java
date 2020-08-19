package com.gildedrose.qualitydelta;


import com.gildedrose.Item;

public class DefaultQualityDeltaStrategy implements QualityDeltaStrategy {

    @Override
    public int qualityDelta(final Item item) {
        if (item.sellIn > 0) {
            return -1;
        }
        return -2;
    }

}
