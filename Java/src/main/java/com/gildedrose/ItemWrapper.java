package com.gildedrose;


import com.gildedrose.qualitydelta.*;

import static com.gildedrose.GildedRose.*;

class ItemWrapper {

    private final Item item;
    private final QualityDeltaStrategy qualityDeltaStrategy;

    private ItemWrapper(final Item item, final QualityDeltaStrategy qualityDeltaStrategy) {
        this.item = item;
        this.qualityDeltaStrategy = qualityDeltaStrategy;
    }

    public static ItemWrapper of(final Item item) {
        switch (item.name) {
            case BACKSTAGE_PASSES:
                return new ItemWrapper(item, new BackstagePassesQualityDeltaStrategy());
            case AGED_BRIE:
                return new ItemWrapper(item, new AgedBrieQualityDeltaStrategy());
            case SULFARAS:
                return new ItemWrapper(item, new SulfarasQualityDeltaStrategy());
            default:
                return new ItemWrapper(item, new DefaultQualityDeltaStrategy());
        }
    }

    void update() {
        updateQuality();
        item.sellIn -= 1;
    }

    private void updateQuality() {
        final int qualityDelta = qualityDeltaStrategy.qualityDelta(item);
        if (qualityDelta > 0) {
            item.quality = Math.min(50, item.quality + qualityDelta);
        }
        if (qualityDelta < 0) {
            item.quality = Math.max(0, item.quality + qualityDelta);
        }
    }

}

