package com.gildedrose.sellindelta;

import com.gildedrose.Item;

public class DefaultSellInDeltaStrategy implements SellInDeltaStrategy {

    @Override
    public int sellInDelta(Item item) {
        return -1;
    }

}
