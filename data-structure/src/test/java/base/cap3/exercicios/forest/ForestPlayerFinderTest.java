package base.cap3.exercicios.forest;

import base.cap3.exercicios.forest.domain.Forest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ForestPlayerFinderTest {

    private ForestPlayerFinder finder;

    private Forest forest;

    @BeforeEach
    void setup() {
        this.forest = new Forest(10);
        this.finder = new ForestPlayerFinder(this.forest);
    }

    @RepeatedTest(50)
    void findRandowIndexPositiveOnly() {
        var index = finder.findRandomIndex();
        assertTrue(index >= 0);
    }

    @RepeatedTest(50)
    void testFindIndexOtherPlayerPositiveOnly() {
        var index = finder.findRandomIndex();
        assertTrue(index >= 0);
    }

    @Test
    void testFindIndexOtherPlayer() {
        var mapTotais = new HashMap<Integer, Integer>();

        IntStream.range(0, 50).forEach((elem) -> {
            var index1 = finder.findRandomIndex();
            var index2 = finder.findIndexOtherPlayer(index1);

            mapTotais.compute(index1, (key, value) -> value == null ? 1 : value + 1);
            mapTotais.compute(index2, (key, value) -> value == null ? 1 : value + 1);
        });

        AtomicInteger totalWithMoreThan20 = new AtomicInteger(0);
        mapTotais.forEach((key, value) -> {
            assertNotEquals(value, 0);

            if (value >= 20) {
                totalWithMoreThan20.set(1);
            }
        });
    }
}