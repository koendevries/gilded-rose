package com.gildedrose.updatableitems;

import com.gildedrose.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BackstagePassesQualityDeltaStrategyTest {

    private final QualityDeltaStrategy backstagePassesQualityDeltaStrategy = new BackstagePassesQualityDeltaStrategy();

    static Stream<Arguments> backstagePassesProvider() {
        return Stream.of(
                arguments(new Item("foo", 11, 10), 1),
                arguments(new Item("foo", 10, 10), 2),
                arguments(new Item("foo", 6, 10), 2),
                arguments(new Item("foo", 5, 10), 3),
                arguments(new Item("foo", 0, 10), 3),
                arguments(new Item("foo", -1, 10), -10),
                arguments(new Item("foo", -2, 10), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("backstagePassesProvider")
    void shouldUpdateBackstageQuality(Item item, int expected) {
        final UpdatableItem updatableItem = UpdatableItemFactory.create(item);

        final int delta = backstagePassesQualityDeltaStrategy.qualityDelta(updatableItem);

        assertEquals(expected, delta);
    }

}
