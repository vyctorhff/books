package br.torugo.livro.designerpatters.caelum.assicrona;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by torugo on 07/04/17.
 */
public class TransacaoAssincronaProxyTest {

	@Test
	public void testAssicrono() throws Exception {
		Transacao transacao = new TransacaoAssincronaProxy(new TransacaoImp());
		transacao.executar();
	}
}