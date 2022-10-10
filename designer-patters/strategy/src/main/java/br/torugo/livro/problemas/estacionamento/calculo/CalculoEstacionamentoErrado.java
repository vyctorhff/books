package br.torugo.livro.problemas.estacionamento.calculo;

public class CalculoEstacionamentoErrado {

	/*private Veiculo veiculo;
	private PeriodoEstacionamento periodo;
	
	public CalculoEstacionamentoErrado(Veiculo veiculo, PeriodoEstacionamento periodo) {
		this.veiculo = veiculo;
		this.periodo = periodo;
	}

	public double calcular() {
		double total = 0.0;
		
		CategoriaVeiculo categoria = veiculo.getCategoriaVeiculo();
		
		if (CategoriaVeiculoEnum.PASSEIO.equals(categoria.getCategoria())) {
			if (periodo.isHoras()) {
				double totalHoras = periodo.getTotalHoras();
				
				total = categoria.getCategoria().getTotalPorHora() * totalHoras;
				
			} else if (periodo.isDiaria()) {
				double totalDiaria = periodo.getTotalDiaria();
			
			} else if (periodo.isMes()) {
				double totalMes = periodo.getTotalMes();
			}
			
		} else if (CategoriaVeiculoEnum.VANS.equals(categoria.getCategoria())) {
			if (periodo.isHoras()) {
				double totalHoras = periodo.getTotalHoras();
				
				total = categoria.getCategoria().getTotalPorHora() * totalHoras;
			}
		}
		
		return total;
	}*/
}
