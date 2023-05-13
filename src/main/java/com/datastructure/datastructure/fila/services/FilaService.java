package com.datastructure.datastructure.fila.services;

import org.springframework.stereotype.Service;

import com.datastructure.datastructure.fila.repositories.FilaRepository;

@Service
public class FilaService {

    private static int capacidade = 5;

    private static FilaRepository<Integer> fila;

    public void enfileirar(Integer elemento) {
        if (fila == null) {
            fila = new FilaRepository<>(capacidade);
        }
        fila.enfileirar(elemento);
    }

    public Integer desenfileirar() {
        return fila.desenfileirar();
    }

    public Integer primeiro() {
        return fila.primeiro();
    }

    public boolean vazia() {
        return fila.vazia();
    }

    public int tamanho() {
        return fila.tamanho();
    }

    public Integer[] getFila() throws Exception {
        Object[] elementosGenericos = fila.getElementos();
        Integer[] elementosInteger = new Integer[elementosGenericos.length];

        for (int i = 0; i < elementosGenericos.length; i++) {
            elementosInteger[i] = (Integer) elementosGenericos[i];
        }

        return elementosInteger;
    }

    public static void setCapacidade(int capacidade) {
        FilaService.capacidade = capacidade;
        fila = new FilaRepository<>(capacidade);
    }

    public void exibir() {
        System.out.println(fila.toString());
    }

    public int inicio() {
        return fila.getInicio();
    }

    public int fim() {
        return fila.getFim();
    }
}
