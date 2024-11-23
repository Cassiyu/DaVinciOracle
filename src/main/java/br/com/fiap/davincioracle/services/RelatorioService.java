package br.com.fiap.davincioracle.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RelatorioService {

    private final JdbcTemplate jdbcTemplate;

    public RelatorioService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String chamarProcedureInserirRelatorio(Long idAnalise, Long idUsuario) {
        String sql = "{call prc_inserir_relatorio(?, ?, ?, ?)}";

        try {
            jdbcTemplate.update(sql, new java.sql.Timestamp(System.currentTimeMillis()), idAnalise, idUsuario, null);
            return "Relatório inserido com sucesso!";
        } catch (Exception e) {
            return "Erro ao inserir relatório: " + e.getMessage();
        }
    }

    public List<Map<String, Object>> buscarTodosRelatorios() {
        String sql = "SELECT * FROM T_DAVINCI_RELATORIO";
        return jdbcTemplate.queryForList(sql);
    }

    public Map<String, Object> buscarRelatorioPorId(Long id) {
        String sql = "SELECT * FROM T_DAVINCI_RELATORIO WHERE id_relatorio = ?";
        return jdbcTemplate.queryForMap(sql, id);
    }

    public String atualizarRelatorio(Long id, Long idAnalise, Long idUsuario) {
        String sql = "UPDATE T_DAVINCI_RELATORIO SET id_analise = ?, id_usuario = ?, hora_relatorio = ? WHERE id_relatorio = ?";

        try {
            int rows = jdbcTemplate.update(sql, idAnalise, idUsuario, new java.sql.Timestamp(System.currentTimeMillis()), id);
            return rows > 0 ? "Relatório atualizado com sucesso!" : "Relatório não encontrado.";
        } catch (Exception e) {
            return "Erro ao atualizar relatório: " + e.getMessage();
        }
    }

    public String deletarRelatorio(Long id) {
        String sql = "DELETE FROM T_DAVINCI_RELATORIO WHERE id_relatorio = ?";

        try {
            int rows = jdbcTemplate.update(sql, id);
            return rows > 0 ? "Relatório deletado com sucesso!" : "Relatório não encontrado.";
        } catch (Exception e) {
            return "Erro ao deletar relatório: " + e.getMessage();
        }
    }
}
