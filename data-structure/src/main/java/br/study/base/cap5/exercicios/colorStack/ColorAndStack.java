package br.study.base.cap5.exercicios.colorStack;

import br.study.base.cap5.pilhas.Pilha;

public record ColorAndStack<T>(
    Pilha<T> pilha,
    ColorStackEnum color
) {
}
