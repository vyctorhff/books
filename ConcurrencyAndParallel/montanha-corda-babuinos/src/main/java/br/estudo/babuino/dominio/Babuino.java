package br.estudo.babuino.dominio;

import br.estudo.babuino.ambiente.Corda;
import br.estudo.babuino.ambiente.Montanha;

/**
 * 
 * @author torugo
 */
public class Babuino extends Thread {

	private Montanha montanha;
	private Direcao direcao;


	public Babuino() {
	}


	@Override
	public void run() {
		super.run();

		if (montanha != null && direcao == null)
			throw new IllegalStateException(
					"Babuino nao esta em uma montanha ou nao tem direcao");

		Corda corda = montanha.getCorda();

		while (true) {
			if (corda.isPodeAtravessar(this)) {

				corda.atravessar(this);
				break;
			} else
				try {
					Babuino.sleep(500);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
		}
		System.err
				.println("------------------------------------------------------------");
		System.err.println("O babuino " + this.getName() + " atravessou!!!");
		System.err.println("Esta na montanha: " + montanha.getLadoMontanha());
		System.err
				.println("------------------------------------------------------------");
	}


	public Direcao getDirecao() {
		return direcao;
	}


	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}


	public Montanha getMontanha() {
		return montanha;
	}


	public void setMontanha(Montanha montanha) {
		this.montanha = montanha;
	}


	@Override
	public boolean equals(Object obj) {

		Babuino b = null;

		if (obj instanceof Babuino)
			b = (Babuino) obj;
		else
			throw new IllegalArgumentException();

		return this.getName().equals(b.getName());
	}


	@Override
	public int hashCode() {
		return this.getName().hashCode();
	}

}
