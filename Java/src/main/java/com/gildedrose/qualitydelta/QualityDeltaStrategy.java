package com.gildedrose.qualitydelta;


import com.gildedrose.ItemWrapper;

public interface QualityDeltaStrategy {


    /**
     * @param item : item to determine the strategy
     * @return difference in quality for specified item
     */
    int qualityDelta(ItemWrapper item);

}

