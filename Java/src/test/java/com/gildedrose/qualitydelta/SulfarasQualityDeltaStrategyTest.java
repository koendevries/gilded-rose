package com.gildedrose.qualitydelta;

import com.gildedrose.Item;
import com.gildedrose.UpdatableItem;
import com.gildedrose.UpdatableItemFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SulfarasQualityDeltaStrategyTest {

    private final SulfarasQualityDeltaStrategy sulfarasQualityDeltaStrategy = new SulfarasQualityDeltaStrategy();

    @Test
    void sulfarasQualityRemainsStable() {
        // given
        final Item item = new Item("foo", 0, 80);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        // when
        final int actual = sulfarasQualityDeltaStrategy.qualityDelta(updatableItem);

        // then
        assertEquals(0, actual);
    }

}
