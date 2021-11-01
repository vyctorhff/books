package br.corrida.movimentar;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.corrida.ambiente.Pista;
import br.corrida.participantes.Coelho;
import br.corrida.participantes.Participante;
import br.corrida.posicao.Posicoes;

class MovimentarTest {

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
	void test_todas_as_movimentacoes() {
		movimentar.movimentar(2);
		movimentar.movimentar(5);
		movimentar.movimentar(7);
		
		assertTrue(movimentar.getPosicoes().getUltima().hasAlgumParticipante());
	}

}
