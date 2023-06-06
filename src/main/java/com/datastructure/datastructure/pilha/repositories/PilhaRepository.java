package com.datastructure.datastructure.pilha.repositories;

import java.util.Arrays;

import com.datastructure.datastructure.pilha.exceptions.EmptyStackException;
import com.datastructure.datastructure.pilha.exceptions.FullStackException;

public class PilhaRepository<T> implements IPilha<T> {

    private T[] elementos;
    private int topo;

    public PilhaRepository(int capacidade) {
        elementos = (T[]) new Object[capacidade];
        topo = -1;
    }

    public void push(T elemento) throws Exception {
        if (topo == elementos.length - 1)
            throw new FullStackException("Pilha cheia");
        topo++;
        elementos[topo] = elemento;
    }

    public T pop() throws Exception {
        if (topo == -1)
            throw new EmptyStackException("Pilha vazia");
        T elemento = elementos[topo];
        elementos[topo] = null;
        topo--;
        return elemento;
    }

    public boolean vazia() {
        return (topo == -1);
    }

    public int tamanho() {
        return (topo + 1);
    }

    public T topo() throws Exception {
        if (topo == -1)
            throw new EmptyStackException("Pilha Vazia");
        return elementos[topo];
    }

    public int getTopo() throws Exception {
        if (topo == -1)
            throw new Exception("Pilha Vazia");
        return topo;
    }

    public T[] getElementos() {
        return elementos;
    }

    @Override
    public String toString() {
        return "PilhaRepository [elementos=" + Arrays.toString(elementos) + ", topo=" + topo + "]";
    }
}
