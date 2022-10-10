package br.torugo.livro.problemas.estacionamento.strategy.calculo;

import java.util.Arrays;
import java.util.List;

import br.torugo.livro.problemas.estacionamento.PeriodoEstacionamento;
import br.torugo.livro.problemas.estacionamento.strategy.calculo.tempo.CalculoEstacionamentoHora;
import br.torugo.livro.problemas.estacionamento.strategy.calculo.tempo.CalculoEstacionamentoMes;
import br.torugo.livro.problemas.estacionamento.strategy.calculo.veiculo.CalculoEstacionamentoDia;

public class CalculoEstacionamentoTempoFactory {

	private CalculoEstacionamentoTempoFactory() {
	}
	
	public static CalculoEstacionamentoTempo getInstanceByPeriodo(PeriodoEstacionamento periodo) {
		List<CalculoEstacionamentoTempo> listaStrategys = Arrays.asList(
			new CalculoEstacionamentoHora(periodo),
			new CalculoEstacionamentoDia(periodo),
			new CalculoEstacionamentoMes(periodo)
		);
		
		CalculoEstacionamentoTempo calculo = listaStrategys.stream()
			.filter((elem) -> elem.isCalcular())
			.findFirst()
			.get();
		
		return calculo;
	}
}
