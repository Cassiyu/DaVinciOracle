package br.com.fiap.davincioracle.controllers;

import br.com.fiap.davincioracle.services.DispositivoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dispositivos")
public class DispositivoController {

    private final DispositivoService dispositivoService;

    public DispositivoController(DispositivoService dispositivoService) {
        this.dispositivoService = dispositivoService;
    }

    // Inserir um dispositivo usando a procedure
    @PostMapping("/inserir")
    public ResponseEntity<String> inserirDispositivo(
            @RequestParam String nome,
            @RequestParam String tipo,
            @RequestParam Double tempoUsoDiario,
            @RequestParam Long medidorId,
            @RequestParam Long usuarioId
    ) {
        String resultado = dispositivoService.chamarProcedureInserirDispositivo(nome, tipo, tempoUsoDiario, medidorId, usuarioId);
        return ResponseEntity.ok(resultado);
    }

    // Listar todos os dispositivos
    @GetMapping
    public ResponseEntity<?> listarDispositivos() {
        return ResponseEntity.ok(dispositivoService.buscarTodosDispositivos());
    }

    // Buscar um dispositivo pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(dispositivoService.buscarDispositivoPorId(id));
    }

    // Atualizar um dispositivo
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarDispositivo(
            @PathVariable Long id,
            @RequestParam String nome,
            @RequestParam String tipo,
            @RequestParam Double tempoUsoDiario
    ) {
        String resultado = dispositivoService.atualizarDispositivo(id, nome, tipo, tempoUsoDiario);
        return ResponseEntity.ok(resultado);
    }

    // Remover um dispositivo pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerDispositivo(@PathVariable Long id) {
        String resultado = dispositivoService.deletarDispositivo(id);
        return ResponseEntity.ok(resultado);
    }
}
