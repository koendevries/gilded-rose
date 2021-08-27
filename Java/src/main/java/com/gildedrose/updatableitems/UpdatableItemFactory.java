package com.gildedrose.updatableitems;

import com.gildedrose.Item;

import static com.gildedrose.updatableitems.qualitydelta.QualityDeltaStrategy.AGED_BRIE_QUALITY_DELTA_STRATEGY;
import static com.gildedrose.updatableitems.qualitydelta.QualityDeltaStrategy.BACKSTAGE_PASSES_QUALITY_DELTA_STRATEGY;
import static com.gildedrose.updatableitems.qualitydelta.QualityDeltaStrategy.CONJURED_QUALITY_DELTA_STRATEGY;
import static com.gildedrose.updatableitems.qualitydelta.QualityDeltaStrategy.DEFAULT_QUALITY_DELTA_STRATEGY;
import static com.gildedrose.updatableitems.qualitydelta.QualityDeltaStrategy.SULFARAS_QUALITY_DELTA_STRATEGY;
import static com.gildedrose.updatableitems.sellindelta.SellInDeltaStrategy.DEFAULT_SELL_IN_DELTA_STRATEGY;
import static com.gildedrose.updatableitems.sellindelta.SellInDeltaStrategy.NON_NEGATIVE_SELL_IN_DELTA_STRATEGY;

public class UpdatableItemFactory {

    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFARAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String CONJURED = "Conjured Mana Cake";

    private UpdatableItemFactory() {}

    public static UpdatableItem create(final Item item) {
        switch (item.name) {
            case BACKSTAGE_PASSES:
                return new UpdatableItem(item, BACKSTAGE_PASSES_QUALITY_DELTA_STRATEGY, DEFAULT_SELL_IN_DELTA_STRATEGY);
            case AGED_BRIE:
                return new UpdatableItem(item, AGED_BRIE_QUALITY_DELTA_STRATEGY, DEFAULT_SELL_IN_DELTA_STRATEGY);
            case SULFARAS:
                return new UpdatableItem(item, SULFARAS_QUALITY_DELTA_STRATEGY, NON_NEGATIVE_SELL_IN_DELTA_STRATEGY);
            case CONJURED:
                return new UpdatableItem(item, CONJURED_QUALITY_DELTA_STRATEGY, DEFAULT_SELL_IN_DELTA_STRATEGY);
            default:
                return new UpdatableItem(item, DEFAULT_QUALITY_DELTA_STRATEGY, DEFAULT_SELL_IN_DELTA_STRATEGY);
        }
    }

}
