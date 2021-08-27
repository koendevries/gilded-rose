package com.gildedrose.updatableitems;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpdatableItemFactoryTest {

    private final QualityDeltaStrategy defaultQualityDeltaStrategy = UpdatableItemFactory.DEFAULT_QUALITY_DELTA_STRATEGY;
    private final QualityDeltaStrategy sulfarasQualityDeltaStrategy = UpdatableItemFactory.SULFARAS_QUALITY_DELTA_STRATEGY;
    private final QualityDeltaStrategy agedBrieQualityDeltaStrategy = UpdatableItemFactory.AGED_BRIE_QUALITY_DELTA_STRATEGY;
    private final QualityDeltaStrategy conjuredQualityDeltaStrategy = UpdatableItemFactory.CONJURED_QUALITY_DELTA_STRATEGY;

    private final SellInDeltaStrategy defaultSellInDeltaStrategy = UpdatableItemFactory.DEFAULT_SELL_IN_DELTA_STRATEGY;
    private final SellInDeltaStrategy nonNegativeSellInDeltaStrategy = UpdatableItemFactory.NON_NEGATIVE_SELL_IN_DELTA_STRATEGY;


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