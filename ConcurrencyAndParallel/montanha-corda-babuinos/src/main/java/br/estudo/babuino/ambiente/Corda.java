package br.estudo.babuino.ambiente;

import java.util.LinkedList;

import br.estudo.babuino.dominio.Babuino;
import br.estudo.babuino.dominio.Direcao;

/**
 *
 * @author torugo
 */
public class Corda {

    private LinkedList<Babuino> babuinos;
    
    private Montanha montanhaDireita;
    private Montanha montanhaEsquerda;
    
    private Direcao direcaoAtual;

    
    public Corda(Montanha direita, Montanha esquerda){
        
        montanhaDireita  = direita;
        montanhaEsquerda = esquerda;
     
        direcaoAtual = null;
        
        babuinos = new LinkedList<Babuino>();
    }

    
    public synchronized Montanha getMontanhaDireita() {
        return montanhaDireita;
    }

    
    public synchronized Montanha getMontanhaEsquerda() {
        return montanhaEsquerda;
    }
    
    
    /**
     * Verifica se a corda esta livre ou se os babuinos
     * que estão atravessando no momento estão indo na mesma
     * direção do babuino que está sendo passado por parametro.
     * 
     * @param Babuino que deseja atravessar.
     * 
     * @return true se estiver livro ou se babuino esta na mesma
     *          direção dos que estão atravessando. false se
     *          a direção do babuino for diferente da atual.
     */
    public synchronized boolean isPodeAtravessar(Babuino babuino) {
        return direcaoAtual == babuino.getDirecao();
    }
    
    
    /**
     * Metodo que permite ao objeto Babuino passar de uma montanha
     * para outra.
     * 
     * @param Babuino que deseja atravessar a corda.
     */
    public synchronized void atravessar(Babuino babuino) {
        
        direcaoAtual = babuino.getDirecao();
        try {

            // Simula o tempo de travessia do animal.
            babuino.wait(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        switch(babuino.getDirecao()) {
            
            case DIREITA:
                if (montanhaEsquerda.hasBabuino(babuino)) {
                    
                    montanhaEsquerda.removerBabuino(babuino); // Retira da montanha atual.
                    montanhaDireita.addBabuino(babuino);      // Inseri na montanha de destino.
                }
                else
                    throw new IllegalStateException();
                
                break;
                
            case ESQUERDA:
                if (montanhaDireita.hasBabuino(babuino)) {
                    
                    montanhaDireita.removerBabuino(babuino);
                    montanhaEsquerda.addBabuino(babuino);
                }
                
                break;
        }
        
        if (babuinos.isEmpty())
            direcaoAtual = null;
        
    }

    
}
