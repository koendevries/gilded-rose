package com.gildedrose.qualitydelta;

import com.gildedrose.Item;
import com.gildedrose.UpdatableItem;
import com.gildedrose.UpdatableItemFactory;
import org.junit.jupiter.api.Test;

import static com.gildedrose.UpdatableItemFactory.CONJURED;
import static org.junit.jupiter.api.Assertions.*;

class ConjuredQualityDeltaStrategyTest {

    private final ConjuredQualityDeltaStrategy conjuredQualityDeltaStrategy = new ConjuredQualityDeltaStrategy();
    private final DefaultQualityDeltaStrategy defaultQualityDeltaStrategy = new DefaultQualityDeltaStrategy();

    @Test
    void conjuredDegradesTwiceAsFastAsDefault() {
        // given
        final Item item = new Item("foo", 0, 10);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        // when
        final int deltaConjured = conjuredQualityDeltaStrategy.qualityDelta(updatableItem);
        final int deltaDefault = defaultQualityDeltaStrategy.qualityDelta(updatableItem);


        // then
        assertEquals(deltaDefault * 2, deltaConjured);
    }

    @Test
    void conjuredDegradesTwiceAsFastAsDefaultAfterDueDate() {
        // given
        final Item item = new Item("foo", -1, 10);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);


        // when
        final int deltaConjured = conjuredQualityDeltaStrategy.qualityDelta(updatableItem);
        final int deltaDefault = defaultQualityDeltaStrategy.qualityDelta(updatableItem);


        // then
        assertEquals(deltaDefault * 2, deltaConjured);
    }

}
