package br.corrida.ambiente;

import br.corrida.movimentar.Movimentar;
import br.corrida.participantes.Participante;
import br.corrida.posicao.Posicao;
import br.corrida.posicao.Posicoes;
import br.corrida.printer.CorridaPrinter;

public class Pista {

	public static final int TOTAL_POSICOES = 20;
	
	private final CorridaPrinter printer;
	private final Sentinela sentinela;
	private final Posicoes posicoes;

	public Pista(CorridaPrinter printer) {
		this.printer = printer;
		
		this.sentinela = new Sentinela();
		this.posicoes = new Posicoes(TOTAL_POSICOES);
	}

	public void avancar(Participante participante, int posicoesAvanco) {
		// Para usar o wait e notify e necessario o synchronized no metodo ou em um objeto
		
		synchronized (this.sentinela) {
			this.sentinela.bloquear();
			
			new Movimentar(posicoes, participante).movimentar(posicoesAvanco);
			
			Posicao posicao = posicoes.findPosicaoParticipante(participante);
			printer.printParticipante(posicao, participante);
			
			this.sentinela.liberar();
		}
	}

	public void resultado(Participante participante) {
		new Resultado(printer, posicoes.getUltima()).avaliar(participante);
	}
	
	public boolean hasVencedor() {
		return posicoes.hasParcipanteNaUltimaPosicao();
	}
}
