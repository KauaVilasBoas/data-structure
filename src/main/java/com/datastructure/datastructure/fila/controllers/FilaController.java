package com.datastructure.datastructure.fila.controllers;

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
    public ResponseEntity<Object> getFila() throws Exception {
        Integer[] lista = filaService.getFila();
        System.out.println("GET FILA");
        // ObjectMapper objectMapper = new ObjectMapper();
        // String json = objectMapper.writeValueAsString(listaString);
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping("/queue")
    public ResponseEntity<Object> queue(@RequestBody QueueDTO queueDTO) throws Exception {
        System.out.println("queue");

        if (queueDTO.valor() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Digite Corretamente");
        }

        filaService.enfileirar(queueDTO.valor());
        filaService.exibir();

        return ResponseEntity.status(HttpStatus.CREATED).body("Empilhado com sucesso");
    }

    @GetMapping("/unqueue")
    public ResponseEntity<Object> unqueue() throws Exception {
        System.out.println("unqueue");

        var valor = filaService.desenfileirar(); 
        filaService.exibir();

        return ResponseEntity.status(HttpStatus.OK).body(valor);
    }

    @GetMapping("/{size}")
    public ResponseEntity<Object> setSize(@PathVariable Integer size) throws Exception {
        System.out.println("size");

        FilaService.setCapacidade(size);
        return ResponseEntity.ok().body(size);
    }

}
