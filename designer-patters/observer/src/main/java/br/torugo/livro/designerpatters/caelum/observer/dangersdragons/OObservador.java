package br.torugo.livro.designerpatters.caelum.observer.dangersdragons;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by torugo on 22/03/17.
 */
public class OObservador implements Observer {

	public void update(Observable o, Object arg) {
		Olho olho = (Olho) o;
		System.out.println("Comida encontrado por: " + olho);
	}
}
