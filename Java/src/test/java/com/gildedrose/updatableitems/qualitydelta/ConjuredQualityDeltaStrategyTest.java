package com.gildedrose.updatableitems.qualitydelta;

import com.gildedrose.Item;
import com.gildedrose.updatableitems.UpdatableItem;
import com.gildedrose.updatableitems.UpdatableItemFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConjuredQualityDeltaStrategyTest {

    private final QualityDeltaStrategy conjuredQualityDeltaStrategy = QualityDeltaStrategy.CONJURED_QUALITY_DELTA_STRATEGY;
    private final QualityDeltaStrategy defaultQualityDeltaStrategy = QualityDeltaStrategy.DEFAULT_QUALITY_DELTA_STRATEGY;

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
