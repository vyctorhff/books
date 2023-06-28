package base.cap3.exercicios.forest;

import base.cap3.exercicios.forest.domain.Forest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForestPlayerFinderTest {
    private Forest forest;

    @BeforeEach
    void setup() {
        this.forest = new Forest(10);
    }

    @RepeatedTest(30)
    void testFind() {
        var finder = new ForestPlayerFinder(this.forest);

        var meeting = finder.find();

        assertNotNull(meeting);
        assertNotEquals(meeting.index1(), meeting.index2());
    }
}