package br.study.trees.cap7.base;

import lombok.Data;

@Data
public class Position<E> {

    private int index;

    private E element;
}
