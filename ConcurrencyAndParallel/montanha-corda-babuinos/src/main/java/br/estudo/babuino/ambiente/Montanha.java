package br.estudo.babuino.ambiente;

import java.util.Collection;
import java.util.Vector;

import br.estudo.babuino.dominio.Babuino;
import br.estudo.babuino.dominio.Direcao;

/**
 *
 * @author torugo
 */
public class Montanha {

    private Corda corda;
    private Collection<Babuino> babuinos;

    private Direcao ladoMontanha;
    
    public Montanha(){
        babuinos = new Vector<Babuino>();
    }

    
    public Corda getCorda() {
        return corda;
    }

    
    public void setCorda(Corda corda) {
        this.corda = corda;
    }
    
    
    public synchronized void addBabuino(Babuino babuino) {
        babuinos.add(babuino);
    }
    
    
    public synchronized boolean removerBabuino(Babuino babuino) {
        return babuinos.remove(babuino);
    }

    
    public Collection<Babuino> getBabuinos() {
        return babuinos;
    }

    
    public Direcao getLadoMontanha() {
        return ladoMontanha;
    }

    
    public void setLadoMontanha(Direcao ladoMontanha) {
        this.ladoMontanha = ladoMontanha;
    }

    
    public boolean hasBabuino(Babuino b) {
        return babuinos.contains(b);
    }
    
}
