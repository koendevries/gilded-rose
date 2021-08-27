package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.gildedrose.updatableitems.UpdatableItemFactory.AGED_BRIE;
import static com.gildedrose.updatableitems.UpdatableItemFactory.BACKSTAGE_PASSES;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {


    @Test
    void qualityOfAnItemIsNeverNegative() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertTrue(app.items[0].quality >= 0);
        assertEquals(-1, items[0].sellIn);
    }


    static Stream<Item> provideHighQualityItems() {
        return Stream.of(
                new Item(BACKSTAGE_PASSES, 11, 50),
                new Item(BACKSTAGE_PASSES, 10, 49),
                new Item(BACKSTAGE_PASSES, 5, 48),
                new Item(AGED_BRIE, -1, 50)
        );
    }

    @ParameterizedTest
    @MethodSource("provideHighQualityItems")
    void qualityOfItemIsNeverMoreThan50(Item item) {
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertTrue(item.quality <= 50);
    }

}
