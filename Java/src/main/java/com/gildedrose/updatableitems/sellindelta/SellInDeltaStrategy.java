package com.gildedrose.updatableitems.sellindelta;

import com.gildedrose.updatableitems.UpdatableItem;

@FunctionalInterface
public interface SellInDeltaStrategy {

    static final SellInDeltaStrategy DEFAULT_SELL_IN_DELTA_STRATEGY = item -> -1;
    static final SellInDeltaStrategy NON_NEGATIVE_SELL_IN_DELTA_STRATEGY = item -> item.getSellIn() > 0 ? -1 : 0;

    /**
     * @param item : item to determine the strategy
     * @return difference in sellIn for specified item
     */
    int sellInDelta(UpdatableItem item);

}
