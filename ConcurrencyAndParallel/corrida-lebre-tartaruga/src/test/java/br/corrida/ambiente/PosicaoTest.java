package br.corrida.ambiente;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.corrida.participantes.Coelho;
import br.corrida.participantes.Participante;
import br.corrida.participantes.Tartaruga;
import br.corrida.posicao.Posicao;

class PosicaoTest {
	
	private Participante p1;
	
	private Participante p2;
	
	@BeforeEach
	public void setup() {
		p1 = new Coelho(null);
		p2 = new Tartaruga(null);
	}

	@Test
	void test_is_dois_participantes_falso() {
		Posicao posicao = new Posicao(0);
		
		posicao.adicionar(p1);
		
		assertFalse(posicao.hasDoisParticipantes());
		
		posicao.remover(p1);
		posicao.adicionar(p2);
		
		assertFalse(posicao.hasDoisParticipantes());
	}

	@Test
	void test_is_dois_participantes_true() {
		Posicao posicao = new Posicao(0);
		
		posicao.adicionar(p1);
		posicao.adicionar(p2);
		
		assertTrue(posicao.hasDoisParticipantes());
	}
}
