package com.gildedrose.updatableitems;

import com.gildedrose.Item;

public class UpdatableItemFactory {

    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFARAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String CONJURED = "Conjured Mana Cake";

    static final QualityDeltaStrategy DEFAULT_QUALITY_DELTA_STRATEGY = item -> item.getSellIn() >= 0 ? -1 : -2;
    static final QualityDeltaStrategy AGED_BRIE_QUALITY_DELTA_STRATEGY = item -> 1;
    static final QualityDeltaStrategy SULFARAS_QUALITY_DELTA_STRATEGY = item -> 0;
    static final QualityDeltaStrategy CONJURED_QUALITY_DELTA_STRATEGY = item -> 2 * DEFAULT_QUALITY_DELTA_STRATEGY.qualityDelta(item);
    static final QualityDeltaStrategy BACKSTAGE_PASSES_QUALITY_DELTA_STRATEGY = new BackstagePassesQualityDeltaStrategy();

    static final SellInDeltaStrategy DEFAULT_SELL_IN_DELTA_STRATEGY = item -> -1;
    static final SellInDeltaStrategy NON_NEGATIVE_SELL_IN_DELTA_STRATEGY = item -> item.getSellIn() > 0 ? -1 : 0;

    private UpdatableItemFactory() {
    }

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
