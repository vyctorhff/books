package br.torugo.livro.problemas.estacionamento.strategy.calculo.tempo;

import br.torugo.livro.problemas.estacionamento.PeriodoEstacionamento;
import br.torugo.livro.problemas.estacionamento.strategy.calculo.CalculoEstacionamentoTempo;

public class CalculoEstacionamentoHora implements CalculoEstacionamentoTempo {
	
	private PeriodoEstacionamento periodo;
	
	public CalculoEstacionamentoHora(PeriodoEstacionamento periodo) {
		this.periodo = periodo;
	}
	
	@Override
	public boolean isCalcular() {
		return periodo.isHoras();
	}
	
	@Override
	public long getTotal() {
		return periodo.getTotal();
	}
	
	@Override
	public double calcularTaxaExtra() {
		double taxaPorHora = 0.0;
		
		if (this.getTotal() >= 10) {
			taxaPorHora = 10;
		}
		
		return taxaPorHora;
	}
	
}
