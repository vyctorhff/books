package br.torugo.livro.designerpatters.caelum;

public class GerenciarContaErrado {

	private final Conta conta;

	public GerenciarContaErrado(Conta conta) {
		this.conta = conta;
	}

	public double deposito(Double valor) {
		conta.depositar(valor);

		if (conta.getValor() <= -100.00) {
			conta.setContaStatus(ContaStatus.BLOQUEADA);

		} else if (conta.getValor() >= 0) {
			conta.setContaStatus(ContaStatus.POSITIVA);

		} else {
			conta.setContaStatus(ContaStatus.NEGATIVA);
		}

		return conta.getValor();
	}

	public double saque(Double valor) {
		switch (conta.getContaStatus()) {
			case POSITIVA:
				conta.sacar(valor);

				if (conta.getValor() > 0) {
					conta.setContaStatus(ContaStatus.NEGATIVA);
				}

				break;

			case NEGATIVA:
				conta.sacar(valor);

				if (conta.getValor() < -100.00) {
					conta.setContaStatus(ContaStatus.BLOQUEADA);
				}

				break;

			case BLOQUEADA:
				break;
		}
		return conta.getValor();
	}

}
