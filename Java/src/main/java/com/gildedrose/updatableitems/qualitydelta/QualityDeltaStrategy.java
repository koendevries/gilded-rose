package com.gildedrose.updatableitems.qualitydelta;


import com.gildedrose.updatableitems.UpdatableItem;

@FunctionalInterface
public interface QualityDeltaStrategy {

    static final QualityDeltaStrategy DEFAULT_QUALITY_DELTA_STRATEGY = item -> item.getSellIn() >= 0 ? -1 : -2;
    static final QualityDeltaStrategy AGED_BRIE_QUALITY_DELTA_STRATEGY = item -> 1;
    static final QualityDeltaStrategy SULFARAS_QUALITY_DELTA_STRATEGY = item -> 0;
    static final QualityDeltaStrategy CONJURED_QUALITY_DELTA_STRATEGY = item -> 2 * DEFAULT_QUALITY_DELTA_STRATEGY.qualityDelta(item);
    static final QualityDeltaStrategy BACKSTAGE_PASSES_QUALITY_DELTA_STRATEGY = new BackstagePassesQualityDeltaStrategy();

    /**
     * @param item : item to determine the strategy
     * @return difference in quality for specified item
     */
    int qualityDelta(UpdatableItem item);

}

