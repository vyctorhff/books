package br.torugo.livro.designerpatters.caelum.state;

public interface OperacaoConta {
	Double deposito(State state, Double valor);
	Double saque(State state, Double valor);
}
