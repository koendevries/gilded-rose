package com.gildedrose.qualitydelta;


import com.gildedrose.ItemWrapper;

public class BackstagePassesQualityDeltaStrategy implements QualityDeltaStrategy {

    private static final int TEN_DAYS_LEFT = 10;
    private static final int FIVE_DAYS_LEFT = 5;
    private static final int ONE_DAY_AFTER = -1;

    @Override
    public int qualityDelta(final ItemWrapper item) {
        if (item.getSellIn() > TEN_DAYS_LEFT) {
            return 1;
        } else if (item.getSellIn() > FIVE_DAYS_LEFT) {
            return 2;
        } else if (item.getSellIn() > ONE_DAY_AFTER) {
            return 3;
        } else if (isDayAfterEvent(item)){
            return -item.getQuality();
        } else {
            return 0;
        }
    }

    private boolean isDayAfterEvent(ItemWrapper item) {
        return item.getSellIn() == ONE_DAY_AFTER;
    }

}

