package br.estudo.babuino.util;

import br.estudo.babuino.ambiente.Montanha;
import br.estudo.babuino.dominio.Babuino;

/**
 * Responsavel por iniciar inicar as thread de babuinos.
 * 
 * @author torugo
 */
public class ThreadIniciaBabuino extends Thread {

	private Montanha montanha;


	public ThreadIniciaBabuino(Montanha montanha) {
		this.montanha = montanha;
	}


	@Override
	public void run() {
		super.run();
		
		for(Babuino b: montanha.getBabuinos())
            b.start();
	}


	public Montanha getMontanha() {
		return montanha;
	}


	public void setMontanha(Montanha montanha) {
		this.montanha = montanha;
	}
}
