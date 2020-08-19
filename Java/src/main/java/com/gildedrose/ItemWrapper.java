package com.gildedrose;


import com.gildedrose.qualitydelta.*;
import com.gildedrose.sellindelta.DefaultSellInDeltaStrategy;
import com.gildedrose.sellindelta.NonNegativeSellInDeltaStrategy;
import com.gildedrose.sellindelta.SellInDeltaStrategy;

class ItemWrapper {

    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFARAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String CONJURED = "Conjured Mana Cake";

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
        updateQuality();
        updateSellIn();
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

    private void updateSellIn() {
        item.sellIn += sellInDeltaStrategy.sellInDelta(item);
    }

}

