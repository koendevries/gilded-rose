package com.gildedrose.qualitydelta;


import com.gildedrose.Item;

public interface QualityDeltaStrategy {


    /**
     * @param item: item to determine the strategy
     * @return difference in quality for specified item
     */
    int qualityDelta(Item item);

}

