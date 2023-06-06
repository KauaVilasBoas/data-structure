package com.datastructure.datastructure.lista.services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.datastructure.datastructure.lista.repositories.ListaRepository;

@Service
public class ListaService {

    private static ListaRepository lista = new ListaRepository<>();

    public boolean estaVazia() {
        return lista.estaVazia();
    }

    public void inserirInicio(Integer dado) {
        lista.inserirInicio(dado);
    }

    public void inserirFim(Integer dado) {
        lista.inserirFim(dado);
    }

    public Map imprimirLista() {
        return lista.imprimirLista();
    }

    public void inserirMeio(int posicao, Integer elemento) {
        lista.inserirMeio(posicao, elemento);
    }

    public Integer removerInicio() {
        return (Integer) lista.removerInicio();
    }

    public Integer removerFim() {
        return (Integer) lista.removerFim();
    }

}
