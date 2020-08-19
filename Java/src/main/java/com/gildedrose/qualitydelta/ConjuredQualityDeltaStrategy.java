package com.gildedrose.qualitydelta;

import com.gildedrose.ItemWrapper;

public class ConjuredQualityDeltaStrategy implements QualityDeltaStrategy {

    private static final QualityDeltaStrategy defaultQualityDeltaStrategy = new DefaultQualityDeltaStrategy();

    @Override
    public int qualityDelta(final ItemWrapper item) {
        return defaultQualityDeltaStrategy.qualityDelta(item) * 2;
    }
}
