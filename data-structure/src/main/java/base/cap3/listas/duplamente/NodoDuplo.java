/*
 * Created on 16/02/2011, 12:41:43
 * Locate at Natal, Rio Grande do Norte
 *
 * NodoDuplo.java
 *
 * @autor torugo
 */
package base.cap3.listas.duplamente;

import lombok.Data;

/**
 * No para uma lista duplamente encadeada.
 */
@Data
public class NodoDuplo {

    private int elemento;

    private NodoDuplo anterior;

    private NodoDuplo proximo;

    public NodoDuplo() {
    }

    public NodoDuplo(int elemento) {
        this.elemento = elemento;
    }
}
