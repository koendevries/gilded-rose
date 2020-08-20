package com.gildedrose.sellindelta;

import com.gildedrose.Item;
import com.gildedrose.UpdatableItem;
import com.gildedrose.UpdatableItemFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonNegativeSellInDeltaStrategyTest {

    private final NonNegativeSellInDeltaStrategy nonNegativeSellInDeltaStrategy = new NonNegativeSellInDeltaStrategy();

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
