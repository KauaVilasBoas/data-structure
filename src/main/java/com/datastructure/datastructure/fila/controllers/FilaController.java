package com.datastructure.datastructure.fila.controllers;

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

import com.datastructure.datastructure.fila.DTO.QueueDTO;
import com.datastructure.datastructure.fila.services.FilaService;

@RestController
@RequestMapping("api/fila")
public class FilaController {

    @Autowired
    private FilaService filaService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<Object> getFila() {
        try {

            Integer[] lista = filaService.getFila();
            var inicio = filaService.inicio();
            var fim = filaService.fim();

            Map<String, Object> response = new HashMap<>();
            response.put("lista", lista);
            response.put("inicio", inicio);
            response.put("fim", fim);

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Fila vazia");
        }
    }

    @PostMapping("/queue")
    public ResponseEntity<Object> queue(@RequestBody QueueDTO queueDTO) {
        try {

            if (queueDTO.valor() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Digite Corretamente");
            }

            filaService.enfileirar(queueDTO.valor());
            filaService.exibir();

            return ResponseEntity.status(HttpStatus.CREATED).body("Enfileirado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Fila Cheia");
        }

    }

    @GetMapping("/unqueue")
    public ResponseEntity<Object> unqueue() throws Exception {
        try {

            var valor = filaService.desenfileirar();
            filaService.exibir();

            return ResponseEntity.status(HttpStatus.OK).body(valor);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Fila Vazia");
        }

    }

    @GetMapping("/{size}")
    public ResponseEntity<Object> setSize(@PathVariable Integer size) throws Exception {

        FilaService.setCapacidade(size);
        return ResponseEntity.ok().body(size);
    }

}
