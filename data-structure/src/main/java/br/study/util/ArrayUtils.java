package br.study.util;

import java.util.stream.IntStream;

public class ArrayUtils {
    public static int[] subArray(int[] array, int indexBeginning, int indexEnding) {
        return IntStream.range(indexBeginning, indexEnding)
            .map((elem) -> array[elem])
            .toArray();
    }
}
