package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.GildedRose.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

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
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 11, 10)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(10, items[0].sellIn);
        assertEquals(11, items[0].quality);
    }


    @Test
    void backstagePassesQualityIncreasesBy2WhenThereAre10DaysOrLess() {
        // given
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 10, 10)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(9, items[0].sellIn);
        assertEquals(12, items[0].quality);
    }


    @Test
    void backstagePassesQualityIncreasesBy3WhenThereAre5DaysOrLess() {
        // given
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 5, 10)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(4, items[0].sellIn);
        assertEquals(13, items[0].quality);
    }

}
