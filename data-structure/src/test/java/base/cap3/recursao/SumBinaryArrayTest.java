package base.cap3.recursao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumBinaryArrayTest {

    private SumBinaryArray sumBinaryArray;

    @BeforeEach
    void setup() {
        this.sumBinaryArray = new SumBinaryArray();
    }

    @Test
    void testSum() {
        var array = new int[]{1, 2, 3};

        int result = sumBinaryArray.sum(array);

        assertEquals(6, result);
    }
}