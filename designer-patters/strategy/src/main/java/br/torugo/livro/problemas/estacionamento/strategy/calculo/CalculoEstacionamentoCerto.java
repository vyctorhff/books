package br.torugo.livro.problemas.estacionamento.strategy.calculo;

import java.util.Arrays;
import java.util.List;

import br.torugo.livro.problemas.estacionamento.CategoriaVeiculo;
import br.torugo.livro.problemas.estacionamento.PeriodoEstacionamento;
import br.torugo.livro.problemas.estacionamento.Veiculo;
import br.torugo.livro.problemas.estacionamento.strategy.calculo.veiculo.CalculoEstacionamentoPasseio;

public class CalculoEstacionamentoCerto {

	private CalculoEstacionamento calculo;
	
	private Veiculo veiculo;
	
	private PeriodoEstacionamento periodo;

	public CalculoEstacionamentoCerto(Veiculo veiculo, PeriodoEstacionamento periodo) {
		this.veiculo = veiculo;
		this.periodo = periodo;
		
		this.calculo = this.getStrategyCalculoEstacionamento(veiculo.getCategoriaVeiculo());
	}
	
	private CalculoEstacionamento getStrategyCalculoEstacionamento(CategoriaVeiculo categoriaVeiculo) {
		List<CalculoEstacionamento> lista = Arrays.asList(
			new CalculoEstacionamentoPasseio(),
			new CalculoEstacionamentoCaminhao()
		);
		
		CalculoEstacionamento calculo = lista.stream()
				.filter((elem) -> elem.isCalcular(categoriaVeiculo))
				.findFirst()
				.get();
		
		return calculo;
	}
	
	public double calcular() {
		return calculo.calcular(veiculo, periodo);
	}

}
