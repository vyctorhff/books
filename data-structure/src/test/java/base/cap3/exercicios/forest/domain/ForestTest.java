package base.cap3.exercicios.forest.domain;

import base.cap3.exercicios.forest.ForestPlayerFinder;
import org.apache.commons.lang3.NotImplementedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ForestTest {

    private Forest forest;

    @BeforeEach
    void setup() {
        forest = new Forest(3);
    }

    @Test
    void testIsPlayerWonReturningTrue() {
        forest.meet(new Meeting(0, 1));
        forest.meet(new Meeting(0, 2));

        assertTrue(forest.isPlayerWon(0));
    }

    @Test
    void testIsPlayerWonFalsely() {
        forest.meet(new Meeting(0, 1));
        assertFalse(forest.isPlayerWon(0));
    }

    @Test
    void testMeetValid() {
        var forest = new Forest(3);

        forest.meet(new Meeting(0, 1));
        assertTrue(forest.getMeets()[0][1]);
    }

    @Test
    void testMeetWithTheSamePlayer() {
        forest.meet(new Meeting(0, 0));
        assertFalse(forest.getMeets()[0][0]);
    }

    @ParameterizedTest
    @MethodSource("sourceMeetWithInvalid")
    void testMeetWithInvalid(Meeting meeting) {
        assertThrows(IllegalArgumentException.class, () -> {
            forest.meet(meeting);
        });
    }

    private static Stream<Arguments> sourceMeetWithInvalid() {
        return Stream.of(
                Arguments.of(new Meeting(-1, -1)),
                Arguments.of(new Meeting(-1, 0)),
                Arguments.of(new Meeting(0, -1))
        );
    }
}