package com.gildedrose.qualitydelta;


import com.gildedrose.ItemWrapper;

public class BackstagePassesQualityDeltaStrategy implements QualityDeltaStrategy {

    @Override
    public int qualityDelta(final ItemWrapper item) {
        if (item.getSellIn() > 10) {
            return 1;
        } else if (item.getSellIn() > 5) {
            return 2;
        } else if (item.getSellIn() > 0) {
            return 3;
        } else if (item.getSellIn() == 0){
            return -item.getQuality();
        } else {
            return 0;
        }
    }

}

