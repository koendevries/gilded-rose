package com.gildedrose;


import com.gildedrose.updatableitems.UpdatableItemFactory;

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
