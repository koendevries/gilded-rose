package com.gildedrose.sellindelta;

import com.gildedrose.Item;
import com.gildedrose.UpdatableItem;
import com.gildedrose.UpdatableItemFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultSellInDeltaStrategyTest {

    private final DefaultSellInDeltaStrategy defaultSellInDeltaStrategy = new DefaultSellInDeltaStrategy();

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
