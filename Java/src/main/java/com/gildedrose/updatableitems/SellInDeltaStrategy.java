package com.gildedrose.updatableitems;

@FunctionalInterface
interface SellInDeltaStrategy {

    /**
     * @param item : item to determine the strategy
     * @return difference in sellIn for specified item
     */
    int sellInDelta(UpdatableItem item);

}
