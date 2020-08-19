package com.gildedrose.sellindelta;

import com.gildedrose.Item;

public class NonNegativeSellInDeltaStrategy implements SellInDeltaStrategy {

    @Override
    public int sellInDelta(final Item item) {
        if (item.sellIn > 0) {
            return -1;
        }
        return 0;
    }

}
