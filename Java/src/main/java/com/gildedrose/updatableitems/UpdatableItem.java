package com.gildedrose.updatableitems;


import com.gildedrose.Item;
import com.gildedrose.updatableitems.qualitydelta.QualityDeltaStrategy;
import com.gildedrose.updatableitems.sellindelta.SellInDeltaStrategy;

public class UpdatableItem {

    private static final int MAXIMUM_QUALITY = 50;
    private static final int MINIMUM_QUALITY = 0;

    private final Item item;
    private final QualityDeltaStrategy qualityDeltaStrategy;
    private final SellInDeltaStrategy sellInDeltaStrategy;

    UpdatableItem(
            final Item item,
            final QualityDeltaStrategy qualityDeltaStrategy,
            final SellInDeltaStrategy sellInDeltaStrategy) {
        this.item = item;
        this.qualityDeltaStrategy = qualityDeltaStrategy;
        this.sellInDeltaStrategy = sellInDeltaStrategy;
    }

    public void update() {
        updateSellIn();
        updateQuality();
    }

    private void updateQuality() {
        final int qualityDelta = qualityDeltaStrategy.qualityDelta(this);
        if (qualityDelta > 0) {
            item.quality = Math.min(MAXIMUM_QUALITY, item.quality + qualityDelta);
        }
        if (qualityDelta < 0) {
            item.quality = Math.max(MINIMUM_QUALITY, item.quality + qualityDelta);
        }
    }

    private void updateSellIn() {
        item.sellIn += sellInDeltaStrategy.sellInDelta(this);
    }

    public int getQuality() {
        return item.quality;
    }

    public int getSellIn() {
        return item.sellIn;
    }

}

