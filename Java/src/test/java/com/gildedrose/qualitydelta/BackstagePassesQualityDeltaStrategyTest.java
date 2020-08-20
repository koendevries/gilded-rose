package com.gildedrose.qualitydelta;

import com.gildedrose.Item;
import com.gildedrose.UpdatableItem;
import com.gildedrose.UpdatableItemFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackstagePassesQualityDeltaStrategyTest {

    private final BackstagePassesQualityDeltaStrategy backstagePassesQualityDeltaStrategy = new BackstagePassesQualityDeltaStrategy();


    @Test
    void increaseByOne11PlusDaysBeforeEvent() {
        // given
        final Item item = new Item("foo", 11, 10);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        // when
        final int delta = backstagePassesQualityDeltaStrategy.qualityDelta(updatableItem);

        // then
        assertEquals(1, delta);
    }


    @Test
    void increaseByTwo10DaysBeforeEvent() {
        // given
        final Item item = new Item("foo", 10, 10);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        // when
        final int delta = backstagePassesQualityDeltaStrategy.qualityDelta(updatableItem);

        // then
        assertEquals(2, delta);
    }

    @Test
    void increaseByTwo6DaysBeforeEvent() {
        // given
        final Item item = new Item("foo", 6, 10);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        // when
        final int delta = backstagePassesQualityDeltaStrategy.qualityDelta(updatableItem);

        // then
        assertEquals(2, delta);
    }

    @Test
    void increaseByThree5DaysBeforeEvent() {
        // given
        final Item item = new Item("foo", 5, 10);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        // when
        final int delta = backstagePassesQualityDeltaStrategy.qualityDelta(updatableItem);

        // then
        assertEquals(3, delta);
    }

    @Test
    void increaseByThreeAtDayOfEvent() {
        // given
        final Item item = new Item("foo", 0, 10);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        // when
        final int delta = backstagePassesQualityDeltaStrategy.qualityDelta(updatableItem);

        // then
        assertEquals(3, delta);
    }

    @Test
    void dropQualityDayAfterDueDate() {
        // given
        final Item item = new Item("foo", -1, 10);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        // when
        final int delta = backstagePassesQualityDeltaStrategy.qualityDelta(updatableItem);

        // then
        assertEquals(-10, delta);
    }

    @Test
    void remainStableDaysAfterDueDate() {
        // given
        final Item item = new Item("foo", -2, 10);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        // when
        final int delta = backstagePassesQualityDeltaStrategy.qualityDelta(updatableItem);

        // then
        assertEquals(0, delta);
    }

}
