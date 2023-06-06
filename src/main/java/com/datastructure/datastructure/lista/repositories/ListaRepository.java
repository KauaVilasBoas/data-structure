package com.datastructure.datastructure.lista.repositories;

import java.util.HashMap;
import java.util.Map;

public class ListaRepository<T> {

    private No<T> primeiro;
    private int totalDeElementos;

    public ListaRepository() {
        this.primeiro = null;
        this.totalDeElementos = 0;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public int getTotalDeElementos() {
        return totalDeElementos;
    }

    public void inserirInicio(T dado) {
        No<T> novoNo = new No<>(dado);
        if (estaVazia()) {
            primeiro = novoNo;
        } else {
            novoNo.proximo = primeiro;
            primeiro = novoNo;
        }
        totalDeElementos++;
    }

    public void inserirFim(T dado) {
        No<T> novoNo = new No<>(dado);
        if (estaVazia()) {
            primeiro = novoNo;
        } else {
            No<T> atual = primeiro;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
        totalDeElementos++;
    }

    public T removerInicio() {
        if (estaVazia()) {
            return null;
        }

        No<T> noRemovido = primeiro;
        primeiro = primeiro.proximo;
        noRemovido.proximo = null; // Remove a referência ao próximo nó
        totalDeElementos--;

        return noRemovido.dado;
    }

    public T removerFim() {
        if (estaVazia()) {
            return null;
        }

        No<T> noAnterior = null;
        No<T> noAtual = primeiro;

        while (noAtual.proximo != null) {
            noAnterior = noAtual;
            noAtual = noAtual.proximo;
        }

        if (noAnterior == null) {
            // A lista possui apenas um nó
            primeiro = null;
        } else {
            noAnterior.proximo = null;
        }

        totalDeElementos--;
        return noAtual.dado;
    }

    public void removerPosicao(int posicao) {
        if (posicao < 0 || posicao >= totalDeElementos) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
    
        if (posicao == 0) {
            removerInicio();
        } else {
            No<T> anterior = pegaCelula(posicao - 1);
            No<T> noRemovido = anterior.proximo;
            No<T> proximo = noRemovido.proximo;
    
            anterior.proximo = proximo;
            noRemovido.proximo = null; // Remove a referência ao próximo nó
    
            totalDeElementos--;
        }
    }    

    public Map<String, Object> imprimirLista() {
        No<T> atual = primeiro;
    
        StringBuilder strBuild = new StringBuilder();
    
        strBuild.append("[");
    
        while (atual != null) {
            strBuild.append(atual.dado);
            if (atual.proximo != null) {
                strBuild.append(", ");
            }
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
        strBuild.append("]");
        
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("lista", strBuild.toString());
        resultMap.put("totalDeElementos", totalDeElementos);
    
        return resultMap;
    }
    

    public void inserirMeio(int posicao, T elemento) {
        if (posicao == 0) {
            this.inserirInicio(elemento);
        } else if (posicao == totalDeElementos) {
            this.inserirFim(elemento);
        } else {
            No<T> anterior = pegaCelula(posicao - 1);
            No<T> proximo = anterior.proximo;
            No<T> nova = new No<>(elemento);
            nova.proximo = proximo;
            anterior.proximo = nova;
            totalDeElementos++;
        }
    }

    private No<T> pegaCelula(int posicao) {
        No<T> atual = primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        return atual;
    }

}