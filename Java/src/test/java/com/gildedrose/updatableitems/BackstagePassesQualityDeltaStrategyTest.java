package com.gildedrose.updatableitems;

import com.gildedrose.Item;
import com.gildedrose.util.ParameterizedTestData;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstagePassesQualityDeltaStrategyTest {

    private final QualityDeltaStrategy backstagePassesQualityDeltaStrategy = new BackstagePassesQualityDeltaStrategy();

    @ParameterizedTest
    @MethodSource("backstagePassesProvider")
    void shouldUpdateBackstageQuality(ParameterizedTestData parameterizedTestData) {
        final UpdatableItem updatableItem = UpdatableItemFactory.create(parameterizedTestData.item);

        final int delta = backstagePassesQualityDeltaStrategy.qualityDelta(updatableItem);

        assertEquals(parameterizedTestData.expected, delta);
    }

    static Stream<ParameterizedTestData> backstagePassesProvider() {
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

}
