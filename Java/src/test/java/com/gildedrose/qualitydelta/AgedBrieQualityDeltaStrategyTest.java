package com.gildedrose.qualitydelta;

import com.gildedrose.Item;
import com.gildedrose.UpdatableItem;
import com.gildedrose.UpdatableItemFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgedBrieQualityDeltaStrategyTest {

    private final AgedBrieQualityDeltaStrategy agedBrieQualityDeltaStrategy = new AgedBrieQualityDeltaStrategy();

    @Test
    void agedBrieDeltaIsOne() {
        // given
        final Item item = new Item("foo", 0, 0);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        // when
        final int delta = agedBrieQualityDeltaStrategy.qualityDelta(updatableItem);

        // then
        assertEquals(1, delta);
    }

}
