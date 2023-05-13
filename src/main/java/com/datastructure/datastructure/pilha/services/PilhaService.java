package com.datastructure.datastructure.pilha.services;

import org.springframework.stereotype.Service;

import com.datastructure.datastructure.pilha.repositories.PilhaRepository;

@Service
public class PilhaService {

    private static int capacidade = 5;

    private static PilhaRepository<Integer> pilha;

    public void push(Integer valor) throws Exception {
        if (pilha == null) {
            pilha = new PilhaRepository<>(capacidade);
        }
        pilha.push(valor);
    };

    public Integer pop() throws Exception {
        return pilha.pop();
    };

    public Integer getTamanho() throws Exception {
        return pilha.tamanho();
    };

    public Integer getTopo() throws Exception {
        return pilha.topo();
    };

    public Boolean vazia() throws Exception {
        return pilha.vazia();
    };

    public Integer[] getPilha() throws Exception {
        Object[] elementosGenericos = pilha.getElementos();
        Integer[] elementosInteger = new Integer[elementosGenericos.length];

        for (int i = 0; i < elementosGenericos.length; i++) {
            elementosInteger[i] = (Integer) elementosGenericos[i];
        }

        return elementosInteger;
    }

    public static void setCapacidade(int capacidade) {
        PilhaService.capacidade = capacidade;
        pilha = new PilhaRepository<>(capacidade);
    }
}
