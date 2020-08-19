package com.gildedrose.qualitydelta;


import com.gildedrose.Item;

public class AgedBrieQualityDeltaStrategy implements QualityDeltaStrategy {

    @Override
    public int qualityDelta(Item item) {
        return 1;
    }
}

