package br.corrida.util;

import org.apache.commons.lang3.RandomUtils;

public class Dado {

	public int lancar(Integer inicio, Integer fim) {
		return RandomUtils.nextInt(inicio, fim);
	}
}
