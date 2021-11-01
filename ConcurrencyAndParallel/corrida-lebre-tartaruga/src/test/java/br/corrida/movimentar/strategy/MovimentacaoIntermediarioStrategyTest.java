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

class MovimentacaoIntermediarioStrategyTest {

private Movimentar movimentar;
	
	private Participante participante;
	
	private Posicoes posicoes;

	@BeforeEach
	public void setup() {
		Pista pista = new Pista(null);
		participante = new Coelho(pista);
		
		posicoes = new Posicoes(10);
		movimentar = new Movimentar(posicoes, participante);
	}
	
	@Test
	void test_movimento_intermediario() {
		Posicao posicaoInterm = posicoes.getProximo(posicoes.getPrimeira(), 2);
		
		posicaoInterm.adicionar(participante);
		movimentar.setAvanco(3);
		
		 MovimentacaoStrategy strategy = new MovimentacaoIntermediarioStrategy(movimentar);
		 assertTrue(strategy.isAplicavel());
		 
		 Posicao posicao = strategy.movimentar();
		 assertNotNull(posicao);
		 assertEquals(5, posicao.getIndice());
	}
	
	@Test
	void test_movimento_nao_intermediario() {
		Posicao ultima = posicoes.getProximo(posicoes.getPrimeira(), 3);
		
		ultima.adicionar(participante);
		movimentar.setAvanco(9);
		
		 MovimentacaoStrategy strategy = new MovimentacaoIntermediarioStrategy(movimentar);
		 assertFalse(strategy.isAplicavel());
	}

}
