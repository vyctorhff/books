package br.torugo.livro.problemas.estacionamento.strategy.calculo.veiculo;

import br.torugo.livro.problemas.estacionamento.PeriodoEstacionamento;
import br.torugo.livro.problemas.estacionamento.strategy.calculo.CalculoEstacionamentoTempo;

public class CalculoEstacionamentoDia implements CalculoEstacionamentoTempo {

	private PeriodoEstacionamento periodo;
	
	public CalculoEstacionamentoDia(PeriodoEstacionamento periodo) {
		this.periodo = periodo;
	}
	
	@Override
	public boolean isCalcular() {
		return periodo.isDiaria();
	}

	@Override
	public long getTotal() {
		return periodo.getTotal();
	}

	@Override
	public double calcularTaxaExtra() {
		double taxaPorDia = 0.0;
		
		if (this.getTotal() > 10) {
			taxaPorDia = 20;
		}
		
		return taxaPorDia;
	}

}
