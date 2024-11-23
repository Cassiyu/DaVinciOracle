package br.com.fiap.davincioracle.controllers;

import br.com.fiap.davincioracle.services.AnaliseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analises")
public class AnaliseController {

    private final AnaliseService analiseService;

    public AnaliseController(AnaliseService analiseService) {
        this.analiseService = analiseService;
    }


    // Inserir uma análise usando a procedure
    @PostMapping("/inserir")
    public ResponseEntity<String> inserirAnalise(
            @RequestParam Integer potencia,
            @RequestParam Double consumoMensal,
            @RequestParam String classeEficiencia,
            @RequestParam Long dispositivoId,
            @RequestParam Long usuarioId
    ) {
        String resultado = analiseService.chamarProcedureInserirAnalise(potencia, consumoMensal, classeEficiencia, dispositivoId, usuarioId);
        return ResponseEntity.ok(resultado);
    }

    // Listar todas as análises
    @GetMapping
    public ResponseEntity<?> listarAnalises() {
        return ResponseEntity.ok(analiseService.buscarTodasAnalises());
    }

    // Buscar uma análise pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(analiseService.buscarAnalisePorId(id));
    }

    // Atualizar uma análise
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarAnalise(
            @PathVariable Long id,
            @RequestParam Integer potencia,
            @RequestParam Double consumoMensal,
            @RequestParam String classeEficiencia
    ) {
        String resultado = analiseService.atualizarAnalise(id, potencia, consumoMensal, classeEficiencia);
        return ResponseEntity.ok(resultado);
    }

    // Remover uma análise pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerAnalise(@PathVariable Long id) {
        String resultado = analiseService.deletarAnalise(id);
        return ResponseEntity.ok(resultado);
    }
}
