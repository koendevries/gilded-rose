package com.gildedrose.sellindelta;

import com.gildedrose.Item;

public class DefaultSellInDeltaStrategy implements SellInDeltaStrategy {

    @Override
    public int sellInDelta(final Item item) {
        return -1;
    }

}
