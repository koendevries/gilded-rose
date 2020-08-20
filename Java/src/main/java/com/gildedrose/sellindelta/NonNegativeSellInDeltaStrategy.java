package com.gildedrose.sellindelta;

import com.gildedrose.UpdatableItem;

public class NonNegativeSellInDeltaStrategy implements SellInDeltaStrategy {

    @Override
    public int sellInDelta(final UpdatableItem item) {
        if (item.getSellIn() > 0) {
            return -1;
        }
        return 0;
    }

}
