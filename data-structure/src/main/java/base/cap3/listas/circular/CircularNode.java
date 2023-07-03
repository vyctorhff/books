/*
 * Created on 16/02/2011, 15:09:32
 * Locate at Natal, Rio Grande do Norte
 *
 * NodoCircular.java
 *
 * @autor torugo
 */
package base.cap3.listas.circular;

import lombok.Getter;
import lombok.Setter;

public class CircularNode {

    @Getter
    @Setter
    private CircularNode next;

    @Getter
    private final String name;

    public CircularNode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CircularNode{}" + this.name;
    }
}
