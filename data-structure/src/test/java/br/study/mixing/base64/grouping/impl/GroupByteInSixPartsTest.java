package br.study.mixing.base64.grouping.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GroupByteInSixPartsTest {

    private GroupByteInSixParts sut;

    @BeforeEach
    void setup() {
    }

    @Test
    void shouldGroupThreeBytesInFourParts() {
        var input = "00000000 00000000 00000000";
        var expected = "000000 000000 000000 000000";
    }
}