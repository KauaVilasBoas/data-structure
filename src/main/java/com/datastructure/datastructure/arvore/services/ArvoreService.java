package com.datastructure.datastructure.arvore.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.datastructure.datastructure.arvore.exceptions.ValueNotFoundException;
import com.datastructure.datastructure.arvore.repositories.ArvoreRepository;
import com.datastructure.datastructure.arvore.repositories.No;

@Service
public class ArvoreService {

    private static ArvoreRepository tree = new ArvoreRepository();

    public void inserir(Long value) {
        tree.inserir(value);
    }

    public Boolean remover(Long value) throws ValueNotFoundException {
        return tree.remover(value);
    }

    public No buscar(Long chave) {
        return tree.buscar(chave);
    }

    public Map<String, List<Long>> exibir() {
        Map<String, List<Long>> ordens = new HashMap<>();

        List<Long> preOrder = tree.preOrder();
        List<Long> inOrder = tree.inOrder();
        List<Long> posOrder = tree.posOrder();

        ordens.put("preOrder", preOrder);
        ordens.put("inOrder", inOrder);
        ordens.put("posOrder", posOrder);

        return ordens;
    }
}
