package br.study.mixing.base64.grouping.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
class TransformModelTest {

    // for testing, i will put any number not binary
    private static final String SEQUENCE_OF_EIGHT = "01234567";

    private TransformModel sut;

    @BeforeEach
    void setUp() {
    }

    @Test
    void shouldAddSixNumbersAndAddTwoNumbers() {
        Assertions.fail();
    }

    @Test
    void shouldAddTwoNumbersAndSixNumbers() {
        Assertions.fail();
    }

    @Test
    void shouldAddSixNumbersAtTheBeginning() {
        Assertions.fail();
    }

    @Test
    void shouldAddTwoNumbersAtTheBeginning() {
        Assertions.fail();
    }

    @Test
    void shouldAddSixNumbersAtTheEnding() {
        Assertions.fail();
    }

    @Test
    void shouldAddTwoNumbersAtTheEnding() {
        var transform = new TransformModel(SEQUENCE_OF_EIGHT, new ArrayList<>());

        transform.addTwoNumberFromEnding();
        var result = transform.getResult();

        // TODO: go on
        Assertions.fail();
    }
}