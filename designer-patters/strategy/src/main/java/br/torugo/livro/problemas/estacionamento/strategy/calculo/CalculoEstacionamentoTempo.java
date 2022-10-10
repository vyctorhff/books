package br.torugo.livro.problemas.estacionamento.strategy.calculo;

public interface CalculoEstacionamentoTempo {
	
	boolean isCalcular();
	
	long getTotal();

	double calcularTaxaExtra();
}
