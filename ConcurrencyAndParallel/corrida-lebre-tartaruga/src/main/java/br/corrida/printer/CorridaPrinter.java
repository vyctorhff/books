package br.corrida.printer;

import br.corrida.participantes.Participante;
import br.corrida.posicao.Posicao;
import org.apache.commons.lang3.StringUtils;

public class CorridaPrinter {
	
	private boolean passouUmaVez;
	
	private boolean passouDuasVez;

	public void largada() {
		out("BANG, a corrida começou!!!!!");
		blank();
	}
	
	public void printParticipante(Posicao posicao, Participante participante) {
		registrarPassagem();
		
		if (isOsDoisPassaram()) {
			printProgresso(posicao, participante);
			
			if (posicao.hasDoisParticipantes()) {
				out("Ai!!!");
			}
			
			reset();
		} else {
			printProgresso(posicao, participante);
		}
	}

	private boolean isOsDoisPassaram() {
		return passouUmaVez && passouDuasVez;
	}

	private void printProgresso(Posicao posicao, Participante participante) {
		String percurso = StringUtils.repeat(" . ", posicao.getIndice());
		
		out(String.format("%s %s", percurso, participante.getSimbolo()));
	}
	
	public void printVencedor(Participante participante) {
		out("Venceu: " + participante.getNome());
	}
	
	public void printPerdedor(Participante participante) {
		out("Perdeu: " + participante.getNome());
	}
	
	private void reset() {
		separador();
		reinicarPassagem();
	}

	private void reinicarPassagem() {
		passouUmaVez = false;
		passouDuasVez = false;
	}

	public void registrarPassagem() {
		if (!passouUmaVez) {
			passouUmaVez = true;
		} else {
			passouDuasVez = true;
		}
	}
	
	public void separador() {
		out(StringUtils.repeat("-", 70));
	}
	
	private void blank() {
		out(StringUtils.EMPTY);
	}
	
	private void out(String str) {
		System.out.println(str);
	}
}
