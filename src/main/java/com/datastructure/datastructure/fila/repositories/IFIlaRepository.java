package com.datastructure.datastructure.fila.repositories;

import com.datastructure.datastructure.fila.exceptions.EmptyQueueException;
import com.datastructure.datastructure.fila.exceptions.FullSizeException;

public interface IFIlaRepository <T> {

    public void enfileirar(T elemento) throws FullSizeException;

    public T desenfileirar() throws EmptyQueueException;

    public T primeiro() throws EmptyQueueException;

    public boolean vazia();

    public int tamanho();
}