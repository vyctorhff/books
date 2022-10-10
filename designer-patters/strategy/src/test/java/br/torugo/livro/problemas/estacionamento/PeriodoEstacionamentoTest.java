package br.torugo.livro.problemas.estacionamento;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;

public class PeriodoEstacionamentoTest {

	@Test
	public void testIsHora() {
		LocalDateTime entrada = LocalDateTime.now();
		LocalDateTime saida = entrada.plusHours(2);
		
		PeriodoEstacionamento periodo = new PeriodoEstacionamento(entrada, saida);
		assertTrue(periodo.isHoras());
		assertFalse(periodo.isDiaria());
		assertFalse(periodo.isMes());
	}
	
	@Test
	public void testIsDia() {
		LocalDateTime entrada = LocalDateTime.now();
		LocalDateTime saida = entrada.plusDays(2);
		
		PeriodoEstacionamento periodo = new PeriodoEstacionamento(entrada, saida);
		assertFalse(periodo.isHoras());
		assertTrue(periodo.isDiaria());
		assertFalse(periodo.isMes());
	}
	
	@Test
	public void testIsMes() {
		LocalDateTime entrada = LocalDateTime.now();
		LocalDateTime saida = entrada.plusMonths(1);
		
		PeriodoEstacionamento periodo = new PeriodoEstacionamento(entrada, saida);
		assertFalse(periodo.isHoras());
		assertFalse(periodo.isDiaria());
		assertTrue(periodo.isMes());
	}

}
