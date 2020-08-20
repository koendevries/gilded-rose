package com.gildedrose.qualitydelta;

import com.gildedrose.Item;
import com.gildedrose.UpdatableItem;
import com.gildedrose.UpdatableItemFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultQualityDeltaStrategyTest {

    DefaultQualityDeltaStrategy defaultQualityDeltaStrategy = new DefaultQualityDeltaStrategy();

    @Test
    void degradedsByOne() {
        // given
        final Item item = new Item("foo", 0, 10);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        // when
        final int actual = defaultQualityDeltaStrategy.qualityDelta(updatableItem);

        // then
        assertEquals(-1, actual);
    }

    @Test
    void degradedsByTwoAfterDueDate() {
        // given
        final Item item = new Item("foo", -1, 10);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        // when
        final int actual = defaultQualityDeltaStrategy.qualityDelta(updatableItem);

        // then
        assertEquals(-2, actual);
    }

}
