package br.torugo.livro.problemas.estacionamento.calculo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.torugo.livro.problemas.estacionamento.Caminhao;
import br.torugo.livro.problemas.estacionamento.CategoriaVeiculoEnum;
import br.torugo.livro.problemas.estacionamento.PeriodoEstacionamento;
import br.torugo.livro.problemas.estacionamento.Veiculo;
import br.torugo.livro.problemas.estacionamento.strategy.calculo.CalculoEstacionamentoCerto;

public class CalculoEstacionamentoTest {
	
	private static final double MARGEM_ERRO = 0.0001;
	
	private CalculoEstacionamentoHelper helper;
	
	@Before
	public void setup() {
		helper = new CalculoEstacionamentoHelper();
	}
	
	/*
	 * Carro de passeio 
	 */
	
	@Test
	public void testeVeiculoPasseioCom2h() throws Exception {
		PeriodoEstacionamento periodo = helper.getPerido2Horas();
		Veiculo veiculo				  = helper.getVeiculoPorCategoria(CategoriaVeiculoEnum.PASSEIO);
		
		CalculoEstacionamentoCerto calculo = new CalculoEstacionamentoCerto(veiculo, periodo);
		double total = calculo.calcular();
		
		assertEquals(4.0, total, MARGEM_ERRO);
	}
	
	@Test
	public void testeVeiculoPasseioCom10hComTaxaExtra() throws Exception {
		PeriodoEstacionamento periodo = helper.getPerido10Horas();
		Veiculo veiculo				  = helper.getVeiculoPorCategoria(CategoriaVeiculoEnum.PASSEIO);
		
		CalculoEstacionamentoCerto calculo = new CalculoEstacionamentoCerto(veiculo, periodo);
		double total = calculo.calcular();
		
		assertEquals(30.0, total, MARGEM_ERRO);
	}
	
	@Test
	public void testeVeiculoPasseioCom1Dia() throws Exception {
		PeriodoEstacionamento periodo = helper.getPerido1Dia();
		Veiculo veiculo				  = helper.getVeiculoPorCategoria(CategoriaVeiculoEnum.PASSEIO);
		
		CalculoEstacionamentoCerto calculo = new CalculoEstacionamentoCerto(veiculo, periodo);
		double total = calculo.calcular();
		
		assertEquals(2.0, total, MARGEM_ERRO);
	}
	
	@Test
	public void testeVeiculoPasseioCom2Meses() throws Exception {
		PeriodoEstacionamento periodo = helper.getPerido2Meses();
		Veiculo veiculo				  = helper.getVeiculoPorCategoria(CategoriaVeiculoEnum.PASSEIO);
		
		CalculoEstacionamentoCerto calculo = new CalculoEstacionamentoCerto(veiculo, periodo);
		double total = calculo.calcular();
		
		assertEquals(44.0, total, MARGEM_ERRO);
	}
	
	/*
	 * Veiculo Caminhao
	 */
	@Test
	public void testeVeiculoCaminhaoCom2h() throws Exception {
		PeriodoEstacionamento periodo = helper.getPerido2Horas();
		Caminhao caminhao			  = helper.getCaminhao();
		
		CalculoEstacionamentoCerto calculo = new CalculoEstacionamentoCerto(caminhao, periodo);
		double total = calculo.calcular();
		
		assertEquals(390.0, total, MARGEM_ERRO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testeVeiculoCaminhaoComInstanciaSemSerCaminhao() throws Exception {
		PeriodoEstacionamento periodo = helper.getPerido2Horas();
		Veiculo veiculo				  = helper.getVeiculoPorCategoria(CategoriaVeiculoEnum.CAMINHAO);
		
		CalculoEstacionamentoCerto calculo = new CalculoEstacionamentoCerto(veiculo, periodo);
		calculo.calcular();
	}
}
