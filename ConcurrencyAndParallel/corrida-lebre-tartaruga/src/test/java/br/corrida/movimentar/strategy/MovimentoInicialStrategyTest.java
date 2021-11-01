package br.corrida.movimentar.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.corrida.ambiente.Pista;
import br.corrida.movimentar.Movimentar;
import br.corrida.participantes.Coelho;
import br.corrida.participantes.Participante;
import br.corrida.posicao.Posicao;
import br.corrida.posicao.Posicoes;

class MovimentoInicialStrategyTest {

	private Movimentar movimentar;

	@BeforeEach
	public void setup() {
		Pista pista = new Pista(null);
		Participante participante = new Coelho(pista);
		
		Posicoes posicoes = new Posicoes(10);
		movimentar = new Movimentar(posicoes, participante);
	}
	
	@Test
	void test_movimento_inicial() {
		MovimentacaoStrategy strategy = new MovimentoInicialStrategy(movimentar);
		
		assertTrue(strategy.isAplicavel());
		
		Posicao posicao = strategy.movimentar();
		assertNotNull(posicao);
		assertEquals(posicao.getIndice(), 0);
	}

	@Test
	void test_movimento_nao_inicial() {
		MovimentacaoStrategy strategy = new MovimentoInicialStrategy(movimentar);
		strategy.movimentar();
		
		assertFalse(strategy.isAplicavel());
	}
}
