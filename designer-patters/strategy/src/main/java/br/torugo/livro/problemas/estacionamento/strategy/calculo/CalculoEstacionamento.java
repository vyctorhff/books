package br.torugo.livro.problemas.estacionamento.strategy.calculo;

import br.torugo.livro.problemas.estacionamento.CategoriaVeiculo;
import br.torugo.livro.problemas.estacionamento.PeriodoEstacionamento;
import br.torugo.livro.problemas.estacionamento.Veiculo;

/**
 * Classe Principal do Strategy.
 * 
 * @author torugo, at Maria Dantas
 */
public interface CalculoEstacionamento {
	
	boolean isCalcular(CategoriaVeiculo categoria);
	
	double calcular(Veiculo veiculo, PeriodoEstacionamento periodo);
}
