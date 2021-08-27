package com.gildedrose.updatableitem;

import com.gildedrose.Item;

import java.util.function.ToIntFunction;

import static com.gildedrose.updatableitem.UpdatableItem.DEFAULT_QUALITY_DELTA_FUNCTION;

public class UpdatableItemFactory {

    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFARAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String CONJURED = "Conjured Mana Cake";

    static final int TEN_DAYS_LEFT = 10;
    static final int FIVE_DAYS_LEFT = 5;
    static final int ONE_DAY_AFTER = -1;

    private UpdatableItemFactory() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static UpdatableItem create(final Item item) {
        switch (item.name) {
            case BACKSTAGE_PASSES:
                return UpdatableItem.from(item)
                        .withQualityDeltaFunction(backstagePassesQualityDelta());
            case AGED_BRIE:
                return UpdatableItem.from(item)
                        .withQualityDeltaFunction(i -> 1);
            case SULFARAS:
                return UpdatableItem.from(item)
                        .withQualityDeltaFunction(i -> 0)
                        .withSellInDeltaFunction(i -> i.hasPositiveSellIn() ? -1 : 0);
            case CONJURED:
                return UpdatableItem.from(item)
                        .withQualityDeltaFunction(i -> 2 * DEFAULT_QUALITY_DELTA_FUNCTION.applyAsInt(i));
            default:
                return UpdatableItem.from(item);
        }
    }

    private static ToIntFunction<UpdatableItem> backstagePassesQualityDelta() {
        return item -> {
            if (item.getSellIn() > TEN_DAYS_LEFT) {
                return 1;
            } else if (item.getSellIn() > FIVE_DAYS_LEFT) {
                return 2;
            } else if (item.getSellIn() > ONE_DAY_AFTER) {
                return 3;
            } else if (item.getSellIn() == ONE_DAY_AFTER) {
                return -item.getQuality();
            } else {
                return 0;
            }
        };
    }
}
