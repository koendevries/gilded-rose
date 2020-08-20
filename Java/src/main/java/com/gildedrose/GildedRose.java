package com.gildedrose;


class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final Item item : items) {
            UpdatableItemFactory.create(item).update();
        }
    }
}
