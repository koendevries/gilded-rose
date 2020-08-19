package com.gildedrose.qualitydelta;

import com.gildedrose.Item;

public class ConjuredQualityDeltaStrategy implements QualityDeltaStrategy {

    private static final QualityDeltaStrategy defaultQualityDeltaStrategy = new DefaultQualityDeltaStrategy();

    @Override
    public int qualityDelta(final Item item) {
        return defaultQualityDeltaStrategy.qualityDelta(item) * 2;
    }
}
