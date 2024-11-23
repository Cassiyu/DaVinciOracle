package br.com.fiap.davincioracle.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {

    private final JdbcTemplate jdbcTemplate;

    public UsuarioService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String chamarProcedureInserirUsuario(String email) {
        String sql = "{call prc_inserir_usuario(?, ?, ?)}";

        try {
            jdbcTemplate.update(sql, email, new java.sql.Date(System.currentTimeMillis()), null);
            return "Usuário inserido com sucesso!";
        } catch (Exception e) {
            return "Erro ao inserir usuário: " + e.getMessage();
        }
    }

    public List<Map<String, Object>> buscarTodosUsuarios() {
        String sql = "SELECT * FROM T_DAVINCI_USUARIOS";
        return jdbcTemplate.queryForList(sql);
    }

    public Map<String, Object> buscarUsuarioPorId(Long id) {
        String sql = "SELECT * FROM T_DAVINCI_USUARIOS WHERE id_usuario = ?";
        return jdbcTemplate.queryForMap(sql, id);
    }

    public String atualizarUsuario(Long id, String email) {
        String sql = "UPDATE T_DAVINCI_USUARIOS SET edr_email = ? WHERE id_usuario = ?";

        try {
            int rows = jdbcTemplate.update(sql, email, id);
            return rows > 0 ? "Usuário atualizado com sucesso!" : "Usuário não encontrado.";
        } catch (Exception e) {
            return "Erro ao atualizar usuário: " + e.getMessage();
        }
    }

    public String deletarUsuario(Long id) {
        String sql = "DELETE FROM T_DAVINCI_USUARIOS WHERE id_usuario = ?";

        try {
            int rows = jdbcTemplate.update(sql, id);
            return rows > 0 ? "Usuário deletado com sucesso!" : "Usuário não encontrado.";
        } catch (Exception e) {
            return "Erro ao deletar usuário: " + e.getMessage();
        }
    }
}
