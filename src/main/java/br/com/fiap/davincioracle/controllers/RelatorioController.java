package br.com.fiap.davincioracle.controllers;

import br.com.fiap.davincioracle.services.RelatorioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    private final RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    // Inserir um relatório usando a procedure
    @PostMapping("/inserir")
    public ResponseEntity<String> inserirRelatorio(
            @RequestParam Long analiseId,
            @RequestParam Long usuarioId
    ) {
        String resultado = relatorioService.chamarProcedureInserirRelatorio(analiseId, usuarioId);
        return ResponseEntity.ok(resultado);
    }

    // Listar todos os relatórios
    @GetMapping
    public ResponseEntity<?> listarRelatorios() {
        return ResponseEntity.ok(relatorioService.buscarTodosRelatorios());
    }

    // Buscar um relatório pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(relatorioService.buscarRelatorioPorId(id));
    }

    // Atualizar um relatório
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarRelatorio(
            @PathVariable Long id,
            @RequestParam Long analiseId,
            @RequestParam Long idUsuario
    ) {
        String resultado = relatorioService.atualizarRelatorio(id, analiseId, idUsuario);
        return ResponseEntity.ok(resultado);
    }

    // Remover um relatório pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerRelatorio(@PathVariable Long id) {
        String resultado = relatorioService.deletarRelatorio(id);
        return ResponseEntity.ok(resultado);
    }
}
