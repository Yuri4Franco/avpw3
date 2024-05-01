package com.example.projeto.controllers;
import com.example.projeto.dtos.DescontoDTO;
import com.example.projeto.models.DescontoModel;
import com.example.projeto.service.DescontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/descontos")
public class DescontoController {

    @Autowired
    private DescontoService descontoService;

    @PostMapping
    public ResponseEntity<Object> criarDesconto(@RequestBody DescontoDTO descontoDTO) {
        DescontoModel desconto = descontoService.criarDesconto(descontoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(desconto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarDescontoPorId(@PathVariable Integer id) {
        DescontoModel desconto = descontoService.buscarDescontoPorId(id);
        if (desconto != null) {
            return ResponseEntity.ok(desconto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarDesconto(@PathVariable Integer id, @RequestBody DescontoDTO descontoDTO) {
        DescontoModel descontoAtualizado = descontoService.atualizarDesconto(id, descontoDTO);
        if (descontoAtualizado != null) {
            return ResponseEntity.ok(descontoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarDesconto(@PathVariable Integer id) {
        descontoService.deletarDesconto(id);
        return ResponseEntity.noContent().build();
    }
}
