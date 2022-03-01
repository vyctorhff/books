package base.cap5.exercicios.colorStack;

import base.cap5.pilhas.Pilha;

public record ColorAndStack<T>(
        Pilha<T> pilha,
        ColorStackEnum color
) {
}
