package com.gildedrose.sellindelta;

import com.gildedrose.ItemWrapper;

public class NonNegativeSellInDeltaStrategy implements SellInDeltaStrategy {

    @Override
    public int sellInDelta(final ItemWrapper item) {
        if (item.getSellIn() > 0) {
            return -1;
        }
        return 0;
    }

}
