package br.corrida.util;

import org.apache.commons.lang3.RandomUtils;

public class Dado {

	public int lancar(int inicio, int fim) {
		return RandomUtils.nextInt(inicio, fim);
	}
}
