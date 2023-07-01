package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {
    @Test
    void testSubArrayBeginning() {
        var array = new int[]{1,2,3,4};
        var a1 = ArrayUtils.subArray(array, 0, 2);

        assertArrayEquals(new int[]{1,2}, a1);
    }

    @Test
    void testSubArrayDown() {
        var array = new int[]{1,2,3,4};
        var a1 = ArrayUtils.subArray(array, 2, 4);

        assertArrayEquals(new int[]{3,4}, a1);
    }
}