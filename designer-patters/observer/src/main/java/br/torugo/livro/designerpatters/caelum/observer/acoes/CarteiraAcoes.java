package br.torugo.livro.designerpatters.caelum.observer.acoes;

import java.util.*;

/**
 * Created by torugo on 22/03/17.
 */
public class CarteiraAcoes extends Observable {

	private Map<String, Double> acoes;

	private List<Observer> observers;

	public CarteiraAcoes() {
		acoes = new HashMap<String, Double>();
		observers = new ArrayList<Observer>();
	}

	public void adicionarAcao(String str, Double valor) {
		acoes.put(str, valor);
		notificar(str, valor);
	}

	private void notificar(String str, Double valor) {
		for (Observer o : observers) {
			o.update(this,null);
		}
	}

	public void addObservador(Observer observer) {
		observers.add(observer);
	}
}
