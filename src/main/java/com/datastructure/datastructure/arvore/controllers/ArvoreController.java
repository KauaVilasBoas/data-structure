package com.datastructure.datastructure.arvore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastructure.datastructure.arvore.services.ArvoreService;
import com.datastructure.datastructure.arvore.DTOs.InserirValorTreeDTO;
import com.datastructure.datastructure.arvore.exceptions.ValueNotFoundException;


@RestController
@RequestMapping("api/tree")
public class ArvoreController {
    
    @Autowired
    private ArvoreService arvoreService;

    @PostMapping("/add")
    public ResponseEntity<Object> inserir(@RequestBody InserirValorTreeDTO valor){
        arvoreService.inserir(valor.valor());
        return ResponseEntity.status(HttpStatus.CREATED).build();   
    } 

    @DeleteMapping("/remove")
    public ResponseEntity<Object> remove(@RequestBody InserirValorTreeDTO valor) throws ValueNotFoundException{
        arvoreService.remover(valor.valor());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();   
    } 

    @GetMapping
    public ResponseEntity<Object> getTree(){
        var response = arvoreService.exibir();
        return ResponseEntity.status(HttpStatus.OK).body(response);   
    } 
    
}
