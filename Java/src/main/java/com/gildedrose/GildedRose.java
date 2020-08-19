package com.gildedrose;


class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            final ItemWrapper wrappedItem = ItemWrapper.of(item);
            wrappedItem.update();
        }
    }
}
