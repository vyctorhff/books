package br.torugo.livro.designerpatters.caelum.observer.acoes;

import junit.framework.TestCase;

/**
 * Created by torugo on 22/03/17.
 */
public class CarteiraAcoesTest extends TestCase {

	public void testCarteira() throws Exception {
		CarteiraAcoes carteiraAcoes = new CarteiraAcoes();

		carteiraAcoes.addObservador(new AcoesLogger());

		carteiraAcoes.adicionarAcao("vale", 20.0);
	}
}