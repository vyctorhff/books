package br.torugo.livro.designerpatters.caelum.observer.acoes;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by torugo on 22/03/17.
 */
public class AcoesLogger implements Observer {
	public void update(Observable o, Object arg) {
		if (o instanceof CarteiraAcoes) {
			CarteiraAcoes carteiraAcoes = (CarteiraAcoes) o;
			System.out.print("Log para acoes + " + carteiraAcoes.getClass());
		}
	}
}
