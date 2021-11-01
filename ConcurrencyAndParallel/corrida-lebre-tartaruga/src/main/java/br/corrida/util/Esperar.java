package br.corrida.util;

public class Esperar {

	public void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void waitObj(Object ob) {
		try {
			ob.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
