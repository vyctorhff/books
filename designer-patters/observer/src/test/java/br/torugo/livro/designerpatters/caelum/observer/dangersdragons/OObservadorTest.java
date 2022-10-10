package br.torugo.livro.designerpatters.caelum.observer.dangersdragons;

import java.util.Observable;

import org.junit.Test;

public class OObservadorTest {

	@Test
	public void testObservadorEncontrouAlgo() throws Exception {
		OObservador observador = new OObservador();

		Olho o1 = new Olho(observador, 1);
		Olho o2 = new Olho(observador, 3);

		o1.encontrar();
		o2.encontrar();

		// Não funciona, porque não pode setar a variavel changed.
		Observable oo = new Observable();
		oo.addObserver(observador);
		oo.notifyObservers("algum parametro: param1");
	}
}