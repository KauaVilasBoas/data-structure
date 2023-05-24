package com.datastructure.datastructure.fila.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.datastructure.datastructure.fila.exceptions.EmptyQueueException;
import com.datastructure.datastructure.fila.exceptions.FullSizeException;
import com.datastructure.datastructure.fila.repositories.FilaRepository;

@Service
public class FilaService {

    private static int capacidade = 5;

    private static FilaRepository<Integer> fila;

    public void enfileirar(Integer elemento) throws FullSizeException {
        if (fila == null) {
            fila = new FilaRepository<>(capacidade);
        }
        fila.enfileirar(elemento);
    }

    public Integer desenfileirar() throws EmptyQueueException {
        return fila.desenfileirar();
    }

    public Integer primeiro() throws EmptyQueueException {
        return fila.primeiro();
    }

    public boolean vazia() {
        return fila.vazia();
    }

    public int tamanho() {
        return fila.tamanho();
    }

    public Map<String, Object> getFila() throws Exception {
        Object[] elementosGenericos = fila.getElementos();
        Integer[] elementosInteger = new Integer[elementosGenericos.length];

        for (int i = 0; i < elementosGenericos.length; i++) {
            elementosInteger[i] = (Integer) elementosGenericos[i];
        }

        var inicio = this.inicio();
        var fim = this.fim();
        Map<String, Object> response = new HashMap<>();
        response.put("lista", elementosInteger);
        response.put("inicio", inicio);
        response.put("fim", fim);

        return response;
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
