package com.gildedrose.updatableitems.sellindelta;

import com.gildedrose.Item;
import com.gildedrose.updatableitems.UpdatableItem;
import com.gildedrose.updatableitems.UpdatableItemFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SellInDeltaStrategyTest {

    private final SellInDeltaStrategy defaultSellInDeltaStrategy = SellInDeltaStrategy.DEFAULT_SELL_IN_DELTA_STRATEGY;
    private final SellInDeltaStrategy nonNegativeSellInDeltaStrategy = SellInDeltaStrategy.NON_NEGATIVE_SELL_IN_DELTA_STRATEGY;

    @Test
    void defaultSellInShouldDecrease() {
        final Item item = new Item("foo", 1, 0);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        final int actual = defaultSellInDeltaStrategy.sellInDelta(updatableItem);

        assertEquals(-1, actual);
    }

    @Test
    void defaultSellInShouldDecreaseAfterDueDate() {
        final Item item = new Item("foo", -1, 0);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        final int actual = defaultSellInDeltaStrategy.sellInDelta(updatableItem);

        assertEquals(-1, actual);
    }


    @Test
    void nonNegativeSellInShouldDecrease() {
        final Item item = new Item("foo", 1, 0);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        final int actual = nonNegativeSellInDeltaStrategy.sellInDelta(updatableItem);

        assertEquals(-1, actual);
    }

    @Test
    void nonNegativeSellInDeltaShouldBeEqualAfterDueDate() {
        final Item item = new Item("foo", 0, 0);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        final int actual = nonNegativeSellInDeltaStrategy.sellInDelta(updatableItem);

        assertEquals(0, actual);
    }
}