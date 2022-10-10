package br.torugo.livro.problemas.estacionamento;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.google.common.base.MoreObjects;

public class PeriodoEstacionamento {
	
	private LocalDateTime entrada;
	private LocalDateTime saida;
	
	public PeriodoEstacionamento(LocalDateTime entrada, LocalDateTime saida) {
		this.entrada = entrada;
		this.saida = saida;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}
	
	public boolean isHoras() {
		return ChronoUnit.HOURS.between(entrada, saida) < 24;
	}
	
	public boolean isDiaria() {
		long dias = ChronoUnit.DAYS.between(entrada, saida);
		return dias > 0 && dias < 30;
	}
	
	public boolean isMes() {
		return ChronoUnit.MONTHS.between(entrada, saida) >= 1;
	}
	
	public long getTotal() {
		long total = 0;
		
		if (this.isHoras()) {
			total = ChronoUnit.HOURS.between(entrada, saida);
			
		} else if (this.isDiaria()) {
			total = ChronoUnit.DAYS.between(entrada, saida);
			
		} else if (this.isMes()) {
			total = ChronoUnit.MONTHS.between(entrada, saida);
		}
		
		return total;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PeriodoEstacionamento) {
			PeriodoEstacionamento t = (PeriodoEstacionamento) obj;
			
			return new EqualsBuilder()
					.append(entrada, t.getEntrada())
					.append(saida, t.getSaida())
					.build();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(entrada)
				.append(saida)
				.build();
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(PeriodoEstacionamento.class)
				.add("entrada", entrada)
				.add("saida", saida)
				.toString();
	}

}
