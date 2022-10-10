package br.torugo.livro.problemas.estacionamento.strategy.calculo.veiculo;

import br.torugo.livro.problemas.estacionamento.CategoriaVeiculo;
import br.torugo.livro.problemas.estacionamento.CategoriaVeiculoEnum;
import br.torugo.livro.problemas.estacionamento.PeriodoEstacionamento;
import br.torugo.livro.problemas.estacionamento.Veiculo;
import br.torugo.livro.problemas.estacionamento.strategy.calculo.CalculoEstacionamento;
import br.torugo.livro.problemas.estacionamento.strategy.calculo.CalculoEstacionamentoTempo;
import br.torugo.livro.problemas.estacionamento.strategy.calculo.CalculoEstacionamentoTempoFactory;

public class CalculoEstacionamentoPasseio implements CalculoEstacionamento {
	
	private static final double TAXA_CARRO_PASSEIO = 2.0;
	
	public CalculoEstacionamentoPasseio() {
		
	}

	@Override
	public boolean isCalcular(CategoriaVeiculo categoria) {
		return CategoriaVeiculoEnum.PASSEIO.equals(categoria.getCategoria());
	}
	
	@Override
	public double calcular(Veiculo veiculo, PeriodoEstacionamento periodo) {
		CalculoEstacionamentoTempo calculoTempo = 
				CalculoEstacionamentoTempoFactory.getInstanceByPeriodo(periodo);
		
		double taxaPorHora = calculoTempo.calcularTaxaExtra();
		long horas = calculoTempo.getTotal();
		
		return (TAXA_CARRO_PASSEIO * horas) + taxaPorHora;
	}
	
}
