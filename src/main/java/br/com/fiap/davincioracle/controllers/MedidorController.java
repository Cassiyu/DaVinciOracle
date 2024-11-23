package br.com.fiap.davincioracle.controllers;

import br.com.fiap.davincioracle.services.MedidorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medidores")
public class MedidorController {

    private final MedidorService medidorService;

    public MedidorController(MedidorService medidorService) {
        this.medidorService = medidorService;
    }

    // Inserir um medidor usando a procedure
    @PostMapping("/inserir")
    public ResponseEntity<String> inserirMedidor(@RequestParam String nome, @RequestParam Long usuarioId) {
        String resultado = medidorService.chamarProcedureInserirMedidor(nome, usuarioId);
        return ResponseEntity.ok(resultado);
    }

    // Listar todos os medidores
    @GetMapping
    public ResponseEntity<?> listarMedidores() {
        return ResponseEntity.ok(medidorService.buscarTodosMedidores());
    }

    // Buscar um medidor pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(medidorService.buscarMedidorPorId(id));
    }

    // Atualizar um medidor
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarMedidor(
            @PathVariable Long id,
            @RequestParam String nome
    ) {
        String resultado = medidorService.atualizarMedidor(id, nome);
        return ResponseEntity.ok(resultado);
    }

    // Remover um medidor pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerMedidor(@PathVariable Long id) {
        String resultado = medidorService.deletarMedidor(id);
        return ResponseEntity.ok(resultado);
    }
}
