/*
 * Created on 06/2023
 * Locate at Majestic, Parnamirm, Rio Grande do Norte
 *
 * @autor torugo
 */
package base.cap3.recursao;

import lombok.Getter;

public class ReverseArray {

    public int[] process(int[] array) {
        return helper(new ReverArrayEntity(array));
    }

    private int[] helper(ReverArrayEntity entity) {
        if (entity.isLimitRecursion()) {
            return entity.getReverse();
        }

        entity.update();
        return helper(entity);
    }
}

@Getter
class ReverArrayEntity {

    private int indexOriginal;
    private int indexReverse;

    private final int[] original;
    private final int[] reverse;

    public ReverArrayEntity(int[] array) {
        this.original = array;
        this.reverse = new int[array.length];

        this.indexOriginal = array.length - 1;
        this.indexReverse = 0;
    }

    public void update() {
        this.reverse[this.indexReverse] = this.original[this.indexOriginal];

        this.decreaseIndexOriginal();
        this.increaseIndexReverse();
    }

    public void decreaseIndexOriginal() {
        this.indexOriginal -= 1;
    }

    public void increaseIndexReverse() {
        this.indexReverse += 1;
    }

    public boolean isLimitRecursion() {
        return this.indexOriginal < 0;
    }
}