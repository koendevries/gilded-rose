package com.gildedrose.updatableitems;


@FunctionalInterface
interface QualityDeltaStrategy {

    /**
     * @param item : item to determine the strategy
     * @return difference in quality for specified item
     */
    int qualityDelta(UpdatableItem item);

}

