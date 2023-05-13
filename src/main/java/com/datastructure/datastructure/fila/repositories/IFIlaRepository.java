package com.datastructure.datastructure.fila.repositories;

public interface IFIlaRepository <T> {

    public void enfileirar(T elemento);

    public T desenfileirar();

    public T primeiro();

    public boolean vazia();

    public int tamanho();
}