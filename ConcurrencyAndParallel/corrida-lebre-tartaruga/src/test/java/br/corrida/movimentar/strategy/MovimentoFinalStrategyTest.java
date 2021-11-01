package br.corrida.movimentar.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.corrida.ambiente.Pista;
import br.corrida.movimentar.Movimentar;
import br.corrida.participantes.Coelho;
import br.corrida.participantes.Participante;
import br.corrida.posicao.Posicao;
import br.corrida.posicao.Posicoes;

class MovimentoFinalStrategyTest {

	private Movimentar movimentar;
	
	private Participante participante;
	
	private Posicoes posicoes;

	@BeforeEach
	public void setup() {
		Pista pista = new Pista(null);
		participante = new Coelho(pista);
		
		posicoes = new Posicoes(3);
		movimentar = new Movimentar(posicoes, participante);
	}
	
	@Test
	void test_movimento_no_final() {
		Posicao ultima = posicoes.getProximo(posicoes.getPrimeira(), 1);
		
		ultima.adicionar(participante);
		movimentar.setAvanco(4);
		
		 MovimentacaoStrategy strategy = new MovimentoFinalStrategy(movimentar);
		 assertTrue(strategy.isAplicavel());
		 
		 Posicao posicao = strategy.movimentar();
		 assertNotNull(posicao);
		 assertEquals(2, posicao.getIndice());
	}
	
	@Test
	void test_nao_movimento_final() {
		Posicao posicaoInterme = posicoes.getProximo(posicoes.getPrimeira(), 0);
		
		posicaoInterme.adicionar(participante);
		movimentar.setAvanco(1);
		
		 MovimentacaoStrategy strategy = new MovimentoFinalStrategy(movimentar);
		 assertFalse(strategy.isAplicavel());
		 
		 Posicao posicao = strategy.movimentar();
		 assertNull(posicao);
	}

}
