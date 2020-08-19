package com.gildedrose.sellindelta;

import com.gildedrose.ItemWrapper;

public class DefaultSellInDeltaStrategy implements SellInDeltaStrategy {

    @Override
    public int sellInDelta(final ItemWrapper item) {
        return -1;
    }

}
