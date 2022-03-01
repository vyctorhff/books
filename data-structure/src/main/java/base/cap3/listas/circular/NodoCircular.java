/*
 * Created on 16/02/2011, 15:09:32
 * Locate at Natal, Rio Grande do Norte
 *
 * NodoCircular.java
 *
 * @autor torugo
 */
package base.cap3.listas.circular;

import lombok.Data;

@Data
public class NodoCircular {

    private NodoCircular proximo;

    private String nome;

    public NodoCircular(String nome) {
        this.nome = nome;
    }

}
