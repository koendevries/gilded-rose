package com.gildedrose;

import com.gildedrose.qualitydelta.*;
import com.gildedrose.sellindelta.DefaultSellInDeltaStrategy;
import com.gildedrose.sellindelta.NonNegativeSellInDeltaStrategy;

public class UpdatableItemFactory {

    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFARAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String CONJURED = "Conjured Mana Cake";

    private static final DefaultQualityDeltaStrategy DEFAULT_QUALITY_DELTA_STRATEGY = new DefaultQualityDeltaStrategy();
    private static final BackstagePassesQualityDeltaStrategy BACKSTAGE_PASSES_QUALITY_DELTA_STRATEGY = new BackstagePassesQualityDeltaStrategy();
    private static final AgedBrieQualityDeltaStrategy AGED_BRIE_QUALITY_DELTA_STRATEGY = new AgedBrieQualityDeltaStrategy();
    private static final SulfarasQualityDeltaStrategy SULFARAS_QUALITY_DELTA_STRATEGY = new SulfarasQualityDeltaStrategy();
    private static final ConjuredQualityDeltaStrategy CONJURED_QUALITY_DELTA_STRATEGY = new ConjuredQualityDeltaStrategy();

    private static final DefaultSellInDeltaStrategy DEFAULT_SELL_IN_DELTA_STRATEGY = new DefaultSellInDeltaStrategy();
    private static final NonNegativeSellInDeltaStrategy NON_NEGATIVE_SELL_IN_DELTA_STRATEGY = new NonNegativeSellInDeltaStrategy();

    private UpdatableItemFactory() {}

    public static UpdatableItem create(Item item) {
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
