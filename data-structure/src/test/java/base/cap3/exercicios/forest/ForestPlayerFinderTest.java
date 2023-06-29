package base.cap3.exercicios.forest;

import base.cap3.exercicios.forest.domain.Forest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @RepeatedTest(50)
    void testFindIndexOtherPlayer() {
        var index1 = finder.findRandomIndex();
        var index2 = finder.findIndexOtherPlayer(index1);

        assertNotEquals(index1, index2);
    }
}