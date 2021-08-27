package com.gildedrose.updatableitems.sellindelta;

import com.gildedrose.Item;
import com.gildedrose.updatableitems.UpdatableItem;
import com.gildedrose.updatableitems.UpdatableItemFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultSellInDeltaStrategyTest {

    private final SellInDeltaStrategy defaultSellInDeltaStrategy = SellInDeltaStrategy.DEFAULT_SELL_IN_DELTA_STRATEGY;

    @Test
    void degradesByOne() {
        // given
        final Item item = new Item("foo", 1, 0);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        // when
        final int actual = defaultSellInDeltaStrategy.sellInDelta(updatableItem);

        // then
        assertEquals(-1, actual);
    }

    @Test
    void degradesByOneAfterDueDate() {
        // given
        final Item item = new Item("foo", -1, 0);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        // when
        final int actual = defaultSellInDeltaStrategy.sellInDelta(updatableItem);

        // then
        assertEquals(-1, actual);
    }


}
