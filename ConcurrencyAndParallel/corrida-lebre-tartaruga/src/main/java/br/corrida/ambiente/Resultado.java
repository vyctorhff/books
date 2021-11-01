package br.corrida.ambiente;

import br.corrida.participantes.Participante;
import br.corrida.posicao.Posicao;
import br.corrida.printer.CorridaPrinter;

public class Resultado {

	private Posicao ultima;
	private CorridaPrinter printer;

	public Resultado(CorridaPrinter printer, Posicao ultima) {
		this.printer = printer;
		this.ultima = ultima;
	}

	public void avaliar(Participante participante) {
		if (isVenceu(participante)) {
			printer.printVencedor(participante);
		} else {
			printer.printPerdedor(participante);
		}
	}
	
	private boolean isVenceu(Participante participante) {
		return ultima.hasParticipante(participante);
	}
}
