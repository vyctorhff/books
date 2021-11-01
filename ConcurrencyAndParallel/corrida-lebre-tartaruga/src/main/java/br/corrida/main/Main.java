package br.corrida.main;

import br.corrida.ambiente.Pista;
import br.corrida.participantes.Coelho;
import br.corrida.participantes.Tartaruga;
import br.corrida.printer.CorridaPrinter;

public class Main {
	public static void main(String[] args) {
		CorridaPrinter printer = new CorridaPrinter();
		Pista pista = new Pista(printer);

		printer.largada();
		printer.separador();

		Thread coelhoThread = Coelho.toThread(pista);
		Thread tarturaThread = Tartaruga.toThread(pista);

		coelhoThread.start();
		tarturaThread.start();
	}

}
