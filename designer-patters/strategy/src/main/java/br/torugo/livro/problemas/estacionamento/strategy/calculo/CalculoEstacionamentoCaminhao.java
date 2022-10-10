package br.torugo.livro.problemas.estacionamento.strategy.calculo;

import br.torugo.livro.problemas.estacionamento.Caminhao;
import br.torugo.livro.problemas.estacionamento.CategoriaVeiculo;
import br.torugo.livro.problemas.estacionamento.CategoriaVeiculoEnum;
import br.torugo.livro.problemas.estacionamento.PeriodoEstacionamento;
import br.torugo.livro.problemas.estacionamento.Veiculo;

public class CalculoEstacionamentoCaminhao implements CalculoEstacionamento {

	private static final double TAXA_CAMINHAO = 100.0;
	
	private static final double TAXA_POR_EIXOS = 30.0;
	
	private static final double TAXA_POR_PESO = 20.0;
	
	@Override
	public boolean isCalcular(CategoriaVeiculo categoria) {
		return CategoriaVeiculoEnum.CAMINHAO.equals(categoria.getCategoria());
	}

	@Override
	public double calcular(Veiculo veiculo, PeriodoEstacionamento periodo) {
		CalculoEstacionamentoTempo calculoTempo = 
				CalculoEstacionamentoTempoFactory.getInstanceByPeriodo(periodo);

		if (!(veiculo instanceof Caminhao)) {
			throw new IllegalArgumentException("Calculo do caminhao só pode ser aplicado a caminhoes");
		}
		
		Caminhao caminhao = (Caminhao) veiculo;
		
		double totalPorEixos = caminhao.getNumeroEixos() * TAXA_POR_EIXOS;
		double totalPorPeso  = caminhao.getPeso() * TAXA_POR_PESO;
		
		long dias = calculoTempo.getTotal();
		double taxaExtra = calculoTempo.calcularTaxaExtra();
		
		return (TAXA_CAMINHAO * dias ) + taxaExtra + totalPorEixos + totalPorPeso;
	}

}
