package com.gildedrose.qualitydelta;

import com.gildedrose.UpdatableItem;

public class ConjuredQualityDeltaStrategy implements QualityDeltaStrategy {

    private static final QualityDeltaStrategy defaultQualityDeltaStrategy = new DefaultQualityDeltaStrategy();

    @Override
    public int qualityDelta(final UpdatableItem item) {
        return defaultQualityDeltaStrategy.qualityDelta(item) * 2;
    }
}
