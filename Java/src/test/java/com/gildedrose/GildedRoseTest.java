package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemWrapper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {


    @Test
    void qualityDegrades() {
        // given
        Item[] items = new Item[]{new Item("foo", 1, 5)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(0, items[0].sellIn);
        assertEquals(4, items[0].quality);
    }

    @Test
    void qualityDegradesTwiceAsFastAfterSellByDatePassed() {
        // given
        Item[] items = new Item[]{new Item("foo", 0, 5)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(3, items[0].quality);
        assertEquals(-1, items[0].sellIn);
    }


    @Test
    void qualityOfAnItemIsNeverNegative() {
        // given
        Item[] items = new Item[]{new Item("foo", 1, 0)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertTrue(app.items[0].quality >= 0);
        assertEquals(0, items[0].sellIn);
    }

    @Test
    void agedBrieIncreasesInQualityTheOlderItGets() {
        // given
        Item[] items = new Item[]{new Item(AGED_BRIE, 1, 0)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(0, items[0].sellIn);
        assertEquals(1, items[0].quality);
    }


    @Test
    void qualityOfItemIsNeverMoreThan50() {
        // given
        Item[] items = new Item[]{
                new Item(BACKSTAGE_PASSES, 11, 50),
                new Item(BACKSTAGE_PASSES, 10, 49),
                new Item(BACKSTAGE_PASSES, 5, 48),
        };
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        for (Item item : items) {
            assertTrue(app.items[0].quality <= 50);
        }
    }


    @Test
    void qualityOfSulfarasNeverDecreases() {
        // given
        Item[] items = new Item[]{
                new Item(SULFARAS, 1, 80),
                new Item(SULFARAS, 0, 80),
                new Item(SULFARAS, -1, 80)
        };
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        for (Item item : items) {
            assertEquals(80, item.quality);
        }
    }


    @Test
    void sulfarasNeverHasToBeSold() {
        // given
        Item[] items = new Item[]{new Item(SULFARAS, 0, 80)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(0, items[0].sellIn);
    }


    @Test
    void backstagePassesQualityDropsTo0AfterConcert() {
        // given
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 0, 10)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(0, items[0].quality);
    }

    @Test
    void backstagePassesQualityStays0MultipleDaysAfterConcert() {
        // given
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 0, 10)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();
        app.updateQuality();

        // then
        assertEquals(0, items[0].quality);
    }


    @Test
    void backstagePassesQualityIncreases() {
        // given
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 12, 10)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(11, items[0].sellIn);
        assertEquals(11, items[0].quality);
    }


    @Test
    void backstagePassesQualityIncreasesBy2WhenThereAre10DaysOrLess() {
        // given
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 11, 10)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(10, items[0].sellIn);
        assertEquals(12, items[0].quality);
    }


    @Test
    void backstagePassesQualityIncreasesBy3WhenThereAre5DaysOrLess() {
        // given
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 6, 10)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(5, items[0].sellIn);
        assertEquals(13, items[0].quality);
    }

    @Test
    void conjuredItemsDegradeTwiceAsFastAsNormalItems() {
        // given
        final int conjuredQualityBefore = 10;
        final int fooQualityBefore = 10;
        Item[] items = new Item[]{
                new Item(CONJURED, 5, conjuredQualityBefore),
                new Item("foo", 5, fooQualityBefore)
        };
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();
        final int conjuredQualityDelta = items[0].quality - conjuredQualityBefore;
        final int fooQualityDelta = items[1].quality - fooQualityBefore;

        // then
        assertEquals(4, items[0].sellIn);
        assertEquals(4, items[1].sellIn);
        assertEquals(2 * fooQualityDelta, conjuredQualityDelta);
    }


    @Test
    void conjuredItemsDegradeTwiceAsFastAsNormalItemsAfterSellIn() {
        // given
        final int conjuredQualityBefore = 10;
        final int fooQualityBefore = 10;
        Item[] items = new Item[]{
                new Item(CONJURED, -1, conjuredQualityBefore),
                new Item("foo", -1, fooQualityBefore)
        };
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();
        final int conjuredQualityDelta = items[0].quality - conjuredQualityBefore;
        final int fooQualityDelta = items[1].quality - fooQualityBefore;

        // then
        assertEquals(-2, items[0].sellIn);
        assertEquals(-2, items[1].sellIn);
        assertEquals(2 * fooQualityDelta, conjuredQualityDelta);
    }

}
