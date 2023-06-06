package com.datastructure.datastructure.lista.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datastructure.datastructure.lista.DTOs.InserirNoMeioDTO;
import com.datastructure.datastructure.lista.DTOs.InserirValorDTO;
import com.datastructure.datastructure.lista.services.ListaService;

@RestController
@RequestMapping("api/lista")
public class ListaController {

    @Autowired
    private ListaService listaService;

    @PostMapping("/addInicio")
    public ResponseEntity<Object> inserirInicio(@RequestBody InserirValorDTO inserirValorDTO) {
        listaService.inserirInicio(inserirValorDTO.valor());
        listaService.imprimirLista();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addMeio")
    public ResponseEntity<Object> inserirNoMeio(@RequestBody InserirNoMeioDTO inserirNoMeioDTO) {
        listaService.inserirMeio(inserirNoMeioDTO.posicao(), inserirNoMeioDTO.elemento());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addFim")
    public ResponseEntity<Object> inserirFim(@RequestBody InserirValorDTO inserirValorDTO) {
        listaService.inserirFim(inserirValorDTO.valor());
        listaService.imprimirLista();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/removerInicio")
    public ResponseEntity<Object> removerInicio() {
        var response = listaService.removerInicio();
        listaService.imprimirLista();
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/removerFim")
    public ResponseEntity<Object> removerFim() {
        var response = listaService.removerFim();
        listaService.imprimirLista();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/listarLista")
    @ResponseBody
    public ResponseEntity<Object> getAll() {
        var response = listaService.imprimirLista();
        return ResponseEntity.ok().body(response);
    }
}
