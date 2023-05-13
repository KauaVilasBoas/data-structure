package com.datastructure.datastructure.pilha.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datastructure.datastructure.pilha.dto.EmpilharDTO;
import com.datastructure.datastructure.pilha.services.PilhaService;

@RestController
@RequestMapping(value = "api/pilha")
public class PilhaController {

    @Autowired
    private PilhaService pilhaService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<Object> getPilha() throws Exception {
        try {
            var lista = pilhaService.getPilha();
            var topo = pilhaService.getTopo();

            Map<String, Object> response = new HashMap<>();
            response.put("lista", lista);
            response.put("topo", topo);

            return ResponseEntity.ok().body(response);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Pilha vazia");
        }
    }

    @PostMapping("/push")
    public ResponseEntity<Object> push(@RequestBody EmpilharDTO empilharDTO) {

        try {

            if (empilharDTO.valor() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Digite Corretamente");
            }
            pilhaService.push(empilharDTO.valor());
            return ResponseEntity.status(HttpStatus.CREATED).body("Empilhado com sucesso");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Pilha Cheia");
        }

    }

    @GetMapping("/pop")
    public ResponseEntity<Object> pop() {
        try {
            var valor = pilhaService.pop();
            return ResponseEntity.status(HttpStatus.OK).body(valor);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Pilha vazia");
        }
    }

    @GetMapping("/{size}")
    public ResponseEntity<Object> setSize(@PathVariable Integer size) throws Exception {
        PilhaService.setCapacidade(size);
        return ResponseEntity.ok().body(size);
    }
}