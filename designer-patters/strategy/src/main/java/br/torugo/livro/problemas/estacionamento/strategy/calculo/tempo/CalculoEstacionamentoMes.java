package br.torugo.livro.problemas.estacionamento.strategy.calculo.tempo;

import br.torugo.livro.problemas.estacionamento.PeriodoEstacionamento;
import br.torugo.livro.problemas.estacionamento.strategy.calculo.CalculoEstacionamentoTempo;

public class CalculoEstacionamentoMes implements CalculoEstacionamentoTempo {

	private PeriodoEstacionamento periodo;
	
	public CalculoEstacionamentoMes(PeriodoEstacionamento periodo) {
		this.periodo = periodo;
	}
	
	@Override
	public boolean isCalcular() {
		return periodo.isMes();
	}

	@Override
	public long getTotal() {
		return periodo.getTotal();
	}

	@Override
	public double calcularTaxaExtra() {
		return 40.0;
	}

}
