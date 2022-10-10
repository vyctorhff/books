package br.torugo.livro.designerpatters.caelum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GerenciarContaCertoTest {

	private static final double MARGEM_ERROR = 0.001;

	@Test
	public void testDepositarContaPositiva() {
		Conta conta = new Conta(200.0, ContaStatus.POSITIVA);

		GerenciarContaCerto gerenciarContaCerto = new GerenciarContaCerto(conta);
		gerenciarContaCerto.deposito(20.0);

		assertConta(220.0, ContaStatus.POSITIVA, conta);
	}

	@Test
	public void testSacarComPositivaParaNegativa() throws Exception {
		Conta conta = new Conta(200.0, ContaStatus.POSITIVA);

		GerenciarContaCerto gerenciarContaCerto = new GerenciarContaCerto(conta);
		gerenciarContaCerto.saque(201.0);

		assertConta(-1.0, ContaStatus.NEGATIVA, conta);
	}

	@Test
	public void testSacarComPositivaParaBloqueada() throws Exception {
		Conta conta = new Conta(200.0, ContaStatus.POSITIVA);

		GerenciarContaCerto gerenciarContaCerto = new GerenciarContaCerto(conta);
		gerenciarContaCerto.saque(201.0);

		assertConta(-1.0, ContaStatus.NEGATIVA, conta);

		gerenciarContaCerto.saque(50.0);
		assertConta(-51.0, ContaStatus.NEGATIVA, conta);

		gerenciarContaCerto.saque(50.0);
		assertConta(-101.0, ContaStatus.BLOQUEADA, conta);

		gerenciarContaCerto.saque(20.0);
	}

	private void assertConta(Double expected, ContaStatus status, Conta conta) {
		assertEquals(expected, conta.getValor(), MARGEM_ERROR);
		assertEquals(status, conta.getContaStatus());
	}
}