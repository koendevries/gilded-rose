package com.gildedrose.sellindelta;

import com.gildedrose.UpdatableItem;

public interface SellInDeltaStrategy {

    /**
     * @param item : item to determine the strategy
     * @return difference in sellIn for specified item
     */
    int sellInDelta(UpdatableItem item);

}
