package com.gildedrose.updatableitems.qualitydelta;

import com.gildedrose.Item;
import com.gildedrose.updatableitems.UpdatableItem;
import com.gildedrose.updatableitems.UpdatableItemFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstagePassesQualityDeltaStrategyTest {

    private final BackstagePassesQualityDeltaStrategy backstagePassesQualityDeltaStrategy = new BackstagePassesQualityDeltaStrategy();


    static Stream<ParameterizedTestData> itemProvider() {
        return Stream.of(
                new ParameterizedTestData(new Item("foo", 11, 10), 1),
                new ParameterizedTestData(new Item("foo", 10, 10), 2),
                new ParameterizedTestData(new Item("foo", 6, 10), 2),
                new ParameterizedTestData(new Item("foo", 5, 10), 3),
                new ParameterizedTestData(new Item("foo", 0, 10), 3),
                new ParameterizedTestData(new Item("foo", -1, 10), -10),
                new ParameterizedTestData(new Item("foo", -2, 10), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("itemProvider")
    void increaseByOne11PlusDaysBeforeEvent(ParameterizedTestData parameterizedTestData) {
        // given
        final UpdatableItem updatableItem = UpdatableItemFactory.create(parameterizedTestData.item);

        // when
        final int delta = backstagePassesQualityDeltaStrategy.qualityDelta(updatableItem);

        // then
        assertEquals(parameterizedTestData.expected, delta);
    }

    static class ParameterizedTestData {
        public final Item item;
        public final int expected;

        ParameterizedTestData(Item item, int expected) {
            this.item = item;
            this.expected = expected;
        }
    }

}
