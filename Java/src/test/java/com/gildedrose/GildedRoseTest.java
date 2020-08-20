package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.UpdatableItemFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {


    @Test
    void qualityOfAnItemIsNeverNegative() {
        // given
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertTrue(app.items[0].quality >= 0);
        assertEquals(-1, items[0].sellIn);
    }


    @Test
    void qualityOfItemIsNeverMoreThan50() {
        // given
        Item[] items = new Item[]{
                new Item(BACKSTAGE_PASSES, 11, 50),
                new Item(BACKSTAGE_PASSES, 10, 49),
                new Item(BACKSTAGE_PASSES, 5, 48),
                new Item(AGED_BRIE, -1, 50)
        };
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        for (Item item : items) {
            assertTrue(app.items[0].quality <= 50);
        }
    }

}
