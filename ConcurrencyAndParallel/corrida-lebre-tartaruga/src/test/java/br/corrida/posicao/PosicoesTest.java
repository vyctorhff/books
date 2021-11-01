package br.corrida.posicao;

import br.corrida.ambiente.Pista;
import br.corrida.participantes.Coelho;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PosicoesTest {

	private static final Integer TOTAL_POSICOES = Pista.TOTAL_POSICOES;
	private Posicoes posicoes;

	@BeforeEach
	public void setup() {
		posicoes = new Posicoes(TOTAL_POSICOES);
	}
	
	@Test
	void test_get_primeiro() {
		Posicao primeira = posicoes.getPrimeira();
		assertNotNull(primeira);
		assertEquals(0, primeira.getIndice());
	}

	@Test
	void test_get_ultima() {
		Posicao ultima = posicoes.getUltima();
		assertNotNull(ultima);
		assertEquals(TOTAL_POSICOES - 1, ultima.getIndice());
	}

	@Test
	void test_has_parcitipante_na_ultima_posicao() {
		assertFalse(posicoes.hasParcipanteNaUltimaPosicao());

		posicoes.getUltima().adicionar(new Coelho(null));
		assertTrue(posicoes.hasParcipanteNaUltimaPosicao());
	}
	
	@Test
	void test_get_proximo() {
		Posicao proximo = posicoes.getProximo(posicoes.getPrimeira(), 2);
		assertNotNull(proximo);
		assertEquals(2, proximo.getIndice());
	}
	
	@Test
	void test_get_proximo_alem_limite() {
		assertThrows(IllegalArgumentException.class, () ->
				posicoes.getProximo(posicoes.getPrimeira(), TOTAL_POSICOES + 1));
	}
}
