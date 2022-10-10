package br.torugo.livro.problemas.estacionamento.calculo;

import java.time.LocalDateTime;

import br.torugo.livro.problemas.estacionamento.Caminhao;
import br.torugo.livro.problemas.estacionamento.CategoriaVeiculo;
import br.torugo.livro.problemas.estacionamento.CategoriaVeiculoEnum;
import br.torugo.livro.problemas.estacionamento.PeriodoEstacionamento;
import br.torugo.livro.problemas.estacionamento.Veiculo;

public class CalculoEstacionamentoHelper {

	public PeriodoEstacionamento getPerido2Horas() {
		LocalDateTime entrada = LocalDateTime.now();
		LocalDateTime saida = entrada.plusHours(2);
		
		return new PeriodoEstacionamento(entrada, saida);
	}
	
	public PeriodoEstacionamento getPerido10Horas() {
		LocalDateTime entrada = LocalDateTime.now();
		LocalDateTime saida = entrada.plusHours(10);
		
		return new PeriodoEstacionamento(entrada, saida);
	}
	
	public PeriodoEstacionamento getPerido1Dia() {
		LocalDateTime entrada = LocalDateTime.now();
		LocalDateTime saida = entrada.plusDays(1);
		
		return new PeriodoEstacionamento(entrada, saida);
	}
	
	public PeriodoEstacionamento getPerido10Dias() {
		LocalDateTime entrada = LocalDateTime.now();
		LocalDateTime saida = entrada.plusDays(10);
		
		return new PeriodoEstacionamento(entrada, saida);
	}
	
	public PeriodoEstacionamento getPerido25Dias() {
		LocalDateTime entrada = LocalDateTime.now();
		LocalDateTime saida = entrada.plusDays(25);
		
		return new PeriodoEstacionamento(entrada, saida);
	}
	
	public PeriodoEstacionamento getPerido2Meses() {
		LocalDateTime entrada = LocalDateTime.now();
		LocalDateTime saida = entrada.plusMonths(2);
		
		return new PeriodoEstacionamento(entrada, saida);
	}
	
	public CategoriaVeiculo getCategoriaPasseio() {
		return new CategoriaVeiculo(CategoriaVeiculoEnum.PASSEIO);
	}
	
	public Veiculo getVeiculoPorCategoria(CategoriaVeiculoEnum categoriaEnum) {
		return new Veiculo("Carro builder XYZ", new CategoriaVeiculo(categoriaEnum));
	}
	
	public Caminhao getCaminhao() {
		Caminhao caminhao = new Caminhao("Caminhao builder", new CategoriaVeiculo(CategoriaVeiculoEnum.CAMINHAO));
		caminhao.setPeso(2.000);
		caminhao.setNumeroEixos(5);
		return caminhao;
	}

}
