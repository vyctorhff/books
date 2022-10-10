package br.torugo.livro.designerpatters.caelum.observer.dangersdragons;

import java.util.Observable;

import com.google.common.base.MoreObjects;

/**
 * Created by torugo on 22/03/17.
 */
public class Olho extends Observable {
	
	private Integer id;

	public Olho(OObservador observador, Integer id) {
		this.id = id;
		super.addObserver(observador);
	}

	public void encontrar() {
		super.setChanged();
		super.notifyObservers();
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(Olho.class)
				.add("id", id)
				.toString();
	}
}
