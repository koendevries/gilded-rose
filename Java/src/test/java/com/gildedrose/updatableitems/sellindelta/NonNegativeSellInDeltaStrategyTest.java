package com.gildedrose.updatableitems.sellindelta;

import com.gildedrose.Item;
import com.gildedrose.updatableitems.UpdatableItem;
import com.gildedrose.updatableitems.UpdatableItemFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NonNegativeSellInDeltaStrategyTest {

    private final SellInDeltaStrategy nonNegativeSellInDeltaStrategy = SellInDeltaStrategy.NON_NEGATIVE_SELL_IN_DELTA_STRATEGY;

    @Test
    void degradedsByOne() {
        // given
        final Item item = new Item("foo", 1, 0);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        // when
        final int actual = nonNegativeSellInDeltaStrategy.sellInDelta(updatableItem);

        // then
        assertEquals(-1, actual);
    }

    @Test
    void remainsEqualAtDueDate() {
        // given
        final Item item = new Item("foo", 0, 0);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        // when
        final int actual = nonNegativeSellInDeltaStrategy.sellInDelta(updatableItem);

        // then
        assertEquals(0, actual);
    }

}
