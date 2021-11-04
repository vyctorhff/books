package br.estudo.babuino.dominio;

import br.estudo.babuino.ambiente.Montanha;

/**
 * Classe usada para instanciar objeto Babuinos.
 * 
 * @author torugo
 */
public class BabuinoBuilder {

    public BabuinoBuilder() {
    }

    public void criaLista(Montanha direita, Montanha esquerda) {
        
        for (int cont = 0; cont < 5; cont++) {
            Babuino b = getBabuinoDireita();
            b.setName("Babuino Direita(" + cont + ")");

            direita.getBabuinos().add(b); // Adiciono o Babuino na montanha.
            b.setMontanha(direita);      // Adiciona a montanha no Babuino.
        }

        for (int cont = 0; cont < 5; cont++) {
            Babuino b = getBabuinoEsquerda();
            b.setName("Babuino Esquerda(" + cont + "0");

            esquerda.getBabuinos().add(b); // Adiciono o Babuino na montanha.
            b.setMontanha(esquerda);      // Adiciona a montanha no Babuino.
        }
    }

    /**
     * Metodo que cria um babuino com a direção 
     * Direita.
     * A direção indicar para onde o animal deseja
     * ir.
     * 
     * @return Babuino com uma direção
     */
    public Babuino getBabuinoDireita() {
        Babuino b = new Babuino();
        b.setDirecao(Direcao.DIREITA);

        return b;
    }

    /**
     * Metodo que cria um babuino com a direção 
     * Esquerda.
     * A direção indicar para onde o animal deseja
     * ir.
     * 
     * @return Babuino com uma direção.
     */
    public Babuino getBabuinoEsquerda() {
        Babuino b = new Babuino();
        b.setDirecao(Direcao.ESQUERDA);

        return b;
    }
}
