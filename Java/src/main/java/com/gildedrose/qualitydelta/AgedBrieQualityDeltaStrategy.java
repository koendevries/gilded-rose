package com.gildedrose.qualitydelta;


import com.gildedrose.UpdatableItem;

public class AgedBrieQualityDeltaStrategy implements QualityDeltaStrategy {

    @Override
    public int qualityDelta(final UpdatableItem item) {
        return 1;
    }

}

