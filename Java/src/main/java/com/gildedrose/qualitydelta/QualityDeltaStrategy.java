package com.gildedrose.qualitydelta;


import com.gildedrose.UpdatableItem;

public interface QualityDeltaStrategy {


    /**
     * @param item : item to determine the strategy
     * @return difference in quality for specified item
     */
    int qualityDelta(UpdatableItem item);

}

