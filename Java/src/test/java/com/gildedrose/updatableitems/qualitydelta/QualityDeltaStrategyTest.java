package com.gildedrose.updatableitems.qualitydelta;

import com.gildedrose.Item;
import com.gildedrose.updatableitems.UpdatableItem;
import com.gildedrose.updatableitems.UpdatableItemFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityDeltaStrategyTest {

    private final QualityDeltaStrategy defaultQualityDeltaStrategy = QualityDeltaStrategy.DEFAULT_QUALITY_DELTA_STRATEGY;
    private final QualityDeltaStrategy sulfarasQualityDeltaStrategy = QualityDeltaStrategy.SULFARAS_QUALITY_DELTA_STRATEGY;
    private final QualityDeltaStrategy agedBrieQualityDeltaStrategy = QualityDeltaStrategy.AGED_BRIE_QUALITY_DELTA_STRATEGY;
    private final QualityDeltaStrategy conjuredQualityDeltaStrategy = QualityDeltaStrategy.CONJURED_QUALITY_DELTA_STRATEGY;


    @Test
    void defaultShouldDecrease() {
        final Item item = new Item("foo", 0, 10);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        final int actual = defaultQualityDeltaStrategy.qualityDelta(updatableItem);

        assertEquals(-1, actual);
    }

    @Test
    void defaultShouldDecreaseDouble() {
        final Item item = new Item("foo", -1, 10);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        final int actual = defaultQualityDeltaStrategy.qualityDelta(updatableItem);

        assertEquals(-2, actual);
    }

    @Test
    void sulfarasQualityShouldRemainStable() {
        final Item item = new Item("foo", 0, 80);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        final int actual = sulfarasQualityDeltaStrategy.qualityDelta(updatableItem);

        assertEquals(0, actual);
    }

    @Test
    void agedBrieQualityShouldIncrease() {
        final Item item = new Item("foo", 0, 0);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        final int delta = agedBrieQualityDeltaStrategy.qualityDelta(updatableItem);

        assertEquals(1, delta);
    }

    @Test
    void conjuredShouldDecreaseDoubleOfDefault() {
        final Item item = new Item("foo", 0, 10);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        final int deltaConjured = conjuredQualityDeltaStrategy.qualityDelta(updatableItem);
        final int deltaDefault = defaultQualityDeltaStrategy.qualityDelta(updatableItem);

        assertEquals(deltaDefault * 2, deltaConjured);
    }

    @Test
    void conjuredShouldDecreaseDoubleOfDefaultAfterDueDate() {
        final Item item = new Item("foo", -1, 10);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        final int deltaConjured = conjuredQualityDeltaStrategy.qualityDelta(updatableItem);
        final int deltaDefault = defaultQualityDeltaStrategy.qualityDelta(updatableItem);

        assertEquals(deltaDefault * 2, deltaConjured);
    }
}
