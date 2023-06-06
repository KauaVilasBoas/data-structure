package com.datastructure.datastructure.fila.repositories;

import java.util.Arrays;

import com.datastructure.datastructure.fila.exceptions.EmptyQueueException;
import com.datastructure.datastructure.fila.exceptions.FullSizeException;

public class FilaRepository<T> implements IFIlaRepository<T> {

    private T[] elementos;
    private int tamanho;
    private int capacidade;
    private int inicio;
    private int fim;

    public FilaRepository(int capacidade) {
        this.capacidade = capacidade;
        elementos = (T[]) new Object[capacidade];
        tamanho = 0;
        inicio = 0;
        fim = -1;
    }

    public void enfileirar(T elemento) throws FullSizeException {
        if (tamanho == capacidade) {
            throw new FullSizeException("A fila está cheia");
        }
        fim = (fim + 1) % capacidade;
        elementos[fim] = elemento;
        tamanho++;
    }

    public T desenfileirar() throws EmptyQueueException {
        if (tamanho == 0) {
            throw new EmptyQueueException("A fila está vazia");
        }
        T elemento = elementos[inicio];
        elementos[inicio] = null; // Define o elemento como null para remover a referência
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return elemento;
    }

    public T primeiro() throws EmptyQueueException {
        if (tamanho == 0) {
            throw new EmptyQueueException("A fila está vazia");
        }
        return elementos[inicio];
    }

    public boolean vazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }

    public T[] getElementos() {
        return elementos;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getInicio() {
        return inicio;
    }

    public int getFim() {
        return fim;
    }

    @Override
    public String toString() {
        return "FilaRepository [elementos=" + Arrays.toString(elementos) + ", tamanho=" + tamanho + ", capacidade="
                + capacidade + ", inicio=" + inicio + ", fim=" + fim + "]";
    }

}
