package com.gildedrose.updatableitem;

import com.gildedrose.Item;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import static com.gildedrose.util.Integers.decrease;
import static com.gildedrose.util.Integers.increase;
import static com.gildedrose.util.Integers.negative;
import static com.gildedrose.util.Integers.stable;


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
                return new UpdatableItem(item, backStagePasses(), decrease(1));
            case AGED_BRIE:
                return new UpdatableItem(item, increase(1), decrease(1));
            case SULFARAS:
                return new UpdatableItem(item, stable(), decreaseUntil(1, i -> i.getSellIn() > 0));
            case CONJURED:
                return new UpdatableItem(item, decreaseAndDoubleDecreaseAfter(2, negative()), decrease(1));
            default:
                return new UpdatableItem(item, decreaseAndDoubleDecreaseAfter(1, negative()), decrease(1));
        }
    }

    public static ToIntFunction<UpdatableItem> decreaseAndDoubleDecreaseAfter(int amount, IntPredicate doubleAfter) {
        return t -> doubleAfter.test(t.getSellIn())
                ? decrease(amount).applyAsInt(t) * 2
                : decrease(amount).applyAsInt(t);
    }

    public static ToIntFunction<UpdatableItem> decreaseUntil(int amount, Predicate<UpdatableItem> decreasePredicate) {
        return item -> decreasePredicate.test(item)
                ? decrease(amount).applyAsInt(item)
                : 0;
    }

    public static ToIntFunction<UpdatableItem> backStagePasses() {
        return item -> {
            if (item.getSellIn() > TEN_DAYS_LEFT) {
                return 1;
            } else if (item.getSellIn() > FIVE_DAYS_LEFT) {
                return 2;
            } else if (item.getSellIn() > ONE_DAY_AFTER) {
                return 3;
            } else if (isDayAfterEvent(item)) {
                return -item.getQuality();
            } else {
                return 0;
            }
        };
    }

    public static boolean isDayAfterEvent(UpdatableItem item) {
        return item.getSellIn() == ONE_DAY_AFTER;
    }
}
