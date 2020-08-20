package com.gildedrose.sellindelta;

import com.gildedrose.UpdatableItem;

public class DefaultSellInDeltaStrategy implements SellInDeltaStrategy {

    @Override
    public int sellInDelta(final UpdatableItem item) {
        return -1;
    }

}
