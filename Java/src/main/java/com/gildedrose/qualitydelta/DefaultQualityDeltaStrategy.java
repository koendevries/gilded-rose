package com.gildedrose.qualitydelta;


import com.gildedrose.UpdatableItem;

public class DefaultQualityDeltaStrategy implements QualityDeltaStrategy {

    private static final int ZERO_DAYS_LEFT = 0;

    @Override
    public int qualityDelta(final UpdatableItem item) {
        if (item.getSellIn() >= ZERO_DAYS_LEFT) {
            return -1;
        }
        return -2;
    }

}
