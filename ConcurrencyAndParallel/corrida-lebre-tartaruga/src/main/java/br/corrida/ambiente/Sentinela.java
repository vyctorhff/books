package br.corrida.ambiente;

import br.corrida.util.Esperar;

public class Sentinela {

	private boolean sentinela;

	public Sentinela() {}

	public void bloquear() {
		if (sentinela) {
			esperar();
		}
		
		sentinela = true;
	}

	public void liberar() {
		sentinela = false;
		this.notify();
	}

	private void esperar() {
		while (sentinela) {
			new Esperar().waitObj(this);
		}
	}
}