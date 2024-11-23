package br.com.fiap.davincioracle.controllers;

import br.com.fiap.davincioracle.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Inserir um usuário usando a procedure
    @PostMapping("/inserir")
    public ResponseEntity<String> inserirUsuario(@RequestParam String email) {
        String resultado = usuarioService.chamarProcedureInserirUsuario(email);
        return ResponseEntity.ok(resultado);
    }

    // Listar todos os usuários
    @GetMapping
    public ResponseEntity<?> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.buscarTodosUsuarios());
    }

    // Buscar um usuário pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
    }

    // Atualizar um usuário
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarUsuario(
            @PathVariable Long id,
            @RequestParam String email
    ) {
        String resultado = usuarioService.atualizarUsuario(id, email);
        return ResponseEntity.ok(resultado);
    }

    // Remover um usuário pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerUsuario(@PathVariable Long id) {
        String resultado = usuarioService.deletarUsuario(id);
        return ResponseEntity.ok(resultado);
    }
}
