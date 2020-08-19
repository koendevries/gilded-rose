package com.gildedrose.qualitydelta;


import com.gildedrose.ItemWrapper;

public class DefaultQualityDeltaStrategy implements QualityDeltaStrategy {

    @Override
    public int qualityDelta(final ItemWrapper item) {
        if (item.getSellIn() > 0) {
            return -1;
        }
        return -2;
    }

}
