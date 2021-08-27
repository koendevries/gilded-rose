package com.gildedrose.updatableitems.qualitydelta;

import com.gildedrose.Item;
import com.gildedrose.updatableitems.UpdatableItem;
import com.gildedrose.updatableitems.UpdatableItemFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SulfarasQualityDeltaStrategyTest {

    private final QualityDeltaStrategy sulfarasQualityDeltaStrategy = QualityDeltaStrategy.SULFARAS_QUALITY_DELTA_STRATEGY;

    @Test
    void sulfarasQualityRemainsStable() {
        // given
        final Item item = new Item("foo", 0, 80);
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        // when
        final int actual = sulfarasQualityDeltaStrategy.qualityDelta(updatableItem);

        // then
        assertEquals(0, actual);
    }

}
