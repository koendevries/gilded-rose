package com.gildedrose.sellindelta;

import com.gildedrose.Item;

public interface SellInDeltaStrategy {

    /**
     * @param item: item to determine the strategy
     * @return difference in sellIn for specified item
     */
    int sellInDelta(Item item);

}
