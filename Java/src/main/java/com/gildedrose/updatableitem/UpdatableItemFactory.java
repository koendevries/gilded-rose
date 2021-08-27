package com.gildedrose.updatableitem;

import com.gildedrose.Item;

import java.util.function.ToIntFunction;

import static com.gildedrose.util.Integers.constant;
import static com.gildedrose.util.Integers.where;


public class UpdatableItemFactory {

    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFARAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String CONJURED = "Conjured Mana Cake";

    static final int TEN_DAYS_LEFT = 10;
    static final int FIVE_DAYS_LEFT = 5;
    static final int ONE_DAY_AFTER = -1;

    private UpdatableItemFactory() {
    }

    public static UpdatableItem create(final Item item) {
        switch (item.name) {
            case BACKSTAGE_PASSES:
                return new UpdatableItem(item,
                        backStagePassesQualityDelta(),
                        constant(-1));
            case AGED_BRIE:
                return new UpdatableItem(item,
                        constant(1),
                        constant(-1));
            case SULFARAS:
                return new UpdatableItem(item,
                        constant(0),
                        where(UpdatableItem::hasPositiveSellIn, constant(1), constant(0)));
            case CONJURED:
                return new UpdatableItem(item,
                        where(UpdatableItem::hasNegativeSellin, constant(-4), constant(-2)),
                        constant(-1));
            default:
                return new UpdatableItem(item,
                        where(UpdatableItem::hasNegativeSellin, constant(-2), constant(-1)),
                        constant(-1));
        }
    }

    public static ToIntFunction<UpdatableItem> backStagePassesQualityDelta() {
        return item -> {
            if (item.getSellIn() > TEN_DAYS_LEFT) {
                return 1;
            } else if (item.getSellIn() > FIVE_DAYS_LEFT) {
                return 2;
            } else if (item.getSellIn() > ONE_DAY_AFTER) {
                return 3;
            } else if (item.isDayAfterEvent()) {
                return -item.getQuality();
            } else {
                return 0;
            }
        };
    }
}
