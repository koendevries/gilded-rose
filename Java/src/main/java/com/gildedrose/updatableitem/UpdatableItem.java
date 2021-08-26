package com.gildedrose.updatableitem;


import com.gildedrose.Item;

import java.util.function.ToIntFunction;

public class UpdatableItem {

    private static final int MAXIMUM_QUALITY = 50;
    private static final int MINIMUM_QUALITY = 0;

    private final Item item;
    private final ToIntFunction<UpdatableItem> qualityDeltaFunction;
    private final ToIntFunction<UpdatableItem> sellInDeltaFunction;

    UpdatableItem(final Item item,
                  final ToIntFunction<UpdatableItem> qualityDeltaFunction,
                  final ToIntFunction<UpdatableItem> sellInDeltaFunction) {
        this.item = item;
        this.qualityDeltaFunction = qualityDeltaFunction;
        this.sellInDeltaFunction = sellInDeltaFunction;
    }

    public void update() {
        updateSellIn();
        updateQuality();
    }

    private void updateQuality() {
        final int qualityDelta = qualityDeltaFunction.applyAsInt(this);
        if (qualityDelta > 0) {
            item.quality = Math.min(MAXIMUM_QUALITY, item.quality + qualityDelta);
        }
        if (qualityDelta < 0) {
            item.quality = Math.max(MINIMUM_QUALITY, item.quality + qualityDelta);
        }
    }

    private void updateSellIn() {
        item.sellIn += sellInDeltaFunction.applyAsInt(this);
    }

    public int getQuality() {
        return item.quality;
    }

    public int getSellIn() {
        return item.sellIn;
    }

}

