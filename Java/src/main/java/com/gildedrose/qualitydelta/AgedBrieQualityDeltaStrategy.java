package com.gildedrose.qualitydelta;


import com.gildedrose.ItemWrapper;

public class AgedBrieQualityDeltaStrategy implements QualityDeltaStrategy {

    @Override
    public int qualityDelta(final ItemWrapper item) {
        return 1;
    }

}

