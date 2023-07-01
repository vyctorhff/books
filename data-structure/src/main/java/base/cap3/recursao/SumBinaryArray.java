/*
 * Created on 06/2023
 * Locate at Majestic, Parnamirm, Rio Grande do Norte
 */
package base.cap3.recursao;

import util.ArrayUtils;

import java.util.stream.IntStream;

/*
 * Recursion binaryis a two call for recursion methon to solver a problem
 *
A = [1,2,3]
A1 = [1]
    RETORNA 1
A2 = [2,3]
A3 = [2]
    RETORNA 2
A4 = [3]
    RETORNA 3
 */
public class SumBinaryArray {

    public int sum(int[] array) {
        return helper(array);
    }

    private int helper(int[] array) {
        if (array.length == 1) {
            return array[0];
        }

        var indexHalfSize = (int) array.length / 2;
        var indexBeginning = 0;

        var array1 = ArrayUtils.subArray(array, indexBeginning, indexHalfSize);
        var array2 = ArrayUtils.subArray(array, indexHalfSize, array.length);

        return helper(array1) + helper(array2);
    }
}
