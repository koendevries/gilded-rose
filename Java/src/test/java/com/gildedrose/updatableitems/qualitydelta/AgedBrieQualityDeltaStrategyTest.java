package com.gildedrose.updatableitems.qualitydelta;

import com.gildedrose.Item;
import com.gildedrose.updatableitems.UpdatableItem;
import com.gildedrose.updatableitems.UpdatableItemFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgedBrieQualityDeltaStrategyTest {

    private final QualityDeltaStrategy agedBrieQualityDeltaStrategy = QualityDeltaStrategy.AGED_BRIE_QUALITY_DELTA_STRATEGY;

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
