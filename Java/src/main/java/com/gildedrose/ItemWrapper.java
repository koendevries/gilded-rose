package com.gildedrose;


import com.gildedrose.qualitydelta.*;
import com.gildedrose.sellindelta.DefaultSellInDeltaStrategy;
import com.gildedrose.sellindelta.NonNegativeSellInDeltaStrategy;
import com.gildedrose.sellindelta.SellInDeltaStrategy;

public class ItemWrapper {

    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFARAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String CONJURED = "Conjured Mana Cake";
    private static final int MAXIMUM_QUALITY = 50;
    private static final int MINIMUM_QUALITY = 0;

    private final Item item;
    private final QualityDeltaStrategy qualityDeltaStrategy;
    private final SellInDeltaStrategy sellInDeltaStrategy;

    private ItemWrapper(
            final Item item,
            final QualityDeltaStrategy qualityDeltaStrategy,
            final SellInDeltaStrategy sellInDeltaStrategy) {
        this.item = item;
        this.qualityDeltaStrategy = qualityDeltaStrategy;
        this.sellInDeltaStrategy = sellInDeltaStrategy;
    }

    public static ItemWrapper of(final Item item) {
        switch (item.name) {
            case BACKSTAGE_PASSES:
                return new ItemWrapper(item, new BackstagePassesQualityDeltaStrategy(), new DefaultSellInDeltaStrategy());
            case AGED_BRIE:
                return new ItemWrapper(item, new AgedBrieQualityDeltaStrategy(), new DefaultSellInDeltaStrategy());
            case SULFARAS:
                return new ItemWrapper(item, new SulfarasQualityDeltaStrategy(), new NonNegativeSellInDeltaStrategy());
            case CONJURED:
                return new ItemWrapper(item, new ConjuredQualityDeltaStrategy(), new DefaultSellInDeltaStrategy());
            default:
                return new ItemWrapper(item, new DefaultQualityDeltaStrategy(), new DefaultSellInDeltaStrategy());
        }
    }

    void update() {
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

