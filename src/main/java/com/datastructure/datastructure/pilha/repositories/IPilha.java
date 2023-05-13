package com.datastructure.datastructure.pilha.repositories;

public interface IPilha<T> {
    void push(T elemento) throws Exception;
    T pop() throws Exception;
    boolean vazia();
    int tamanho();
    T topo() throws Exception;
    T[] getElementos();
}
