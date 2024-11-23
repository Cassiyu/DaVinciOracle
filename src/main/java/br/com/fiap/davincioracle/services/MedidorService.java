package br.com.fiap.davincioracle.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MedidorService {

    private final JdbcTemplate jdbcTemplate;

    public MedidorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String chamarProcedureInserirMedidor(String nomeMedidor, Long idUsuario) {
        String sql = "{call prc_inserir_medidor(?, ?, ?)}";

        try {
            jdbcTemplate.update(sql, nomeMedidor, idUsuario, null);
            return "Medidor inserido com sucesso!";
        } catch (Exception e) {
            return "Erro ao inserir medidor: " + e.getMessage();
        }
    }

    public List<Map<String, Object>> buscarTodosMedidores() {
        String sql = "SELECT * FROM T_DaVinci_MEDIDOR_ENERGIA";
        return jdbcTemplate.queryForList(sql);
    }

    public Map<String, Object> buscarMedidorPorId(Long id) {
        String sql = "SELECT * FROM T_DAVINCI_MEDIDOR_ENERGIA WHERE id_medidor = ?";
        return jdbcTemplate.queryForMap(sql, id);
    }

    public String atualizarMedidor(Long id, String nomeMedidor) {
        String sql = "UPDATE T_DAVINCI_MEDIDOR_ENERGIA SET nm_medidor = ? WHERE id_medidor = ?";

        try {
            int rows = jdbcTemplate.update(sql, nomeMedidor, id);
            return rows > 0 ? "Medidor atualizado com sucesso!" : "Medidor não encontrado.";
        } catch (Exception e) {
            return "Erro ao atualizar medidor: " + e.getMessage();
        }
    }

    public String deletarMedidor(Long id) {
        String sql = "DELETE FROM T_DAVINCI_MEDIDOR_ENERGIA WHERE id_medidor = ?";

        try {
            int rows = jdbcTemplate.update(sql, id);
            return rows > 0 ? "Medidor deletado com sucesso!" : "Medidor não encontrado.";
        } catch (Exception e) {
            return "Erro ao deletar medidor: " + e.getMessage();
        }
    }
}
