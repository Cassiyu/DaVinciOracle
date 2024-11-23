package br.com.fiap.davincioracle.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AnaliseService {

    private final JdbcTemplate jdbcTemplate;

    public AnaliseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String chamarProcedureInserirAnalise(Integer potenciaRegistrada, Double consumoMensal,
                                                String classeEficiencia, Long idDispositivo, Long idUsuario) {
        String sql = "{call prc_inserir_analise(?, ?, ?, ?, ?, ?)}";

        try {
            jdbcTemplate.update(sql, potenciaRegistrada, consumoMensal, classeEficiencia, idDispositivo, idUsuario, null);
            return "Análise inserida com sucesso!";
        } catch (Exception e) {
            return "Erro ao inserir análise: " + e.getMessage();
        }
    }

    public List<Map<String, Object>> buscarTodasAnalises() {
        String sql = "SELECT * FROM T_DAVINCI_ANALISE_DISPOSITIVO";
        return jdbcTemplate.queryForList(sql);
    }

    public Map<String, Object> buscarAnalisePorId(Long id) {
        String sql = "SELECT * FROM T_DAVINCI_ANALISE_DISPOSITIVO WHERE id_analise = ?";
        return jdbcTemplate.queryForMap(sql, id);
    }

    public String atualizarAnalise(Long id, Integer potenciaRegistrada, Double consumoMensal, String classeEficiencia) {
        String sql = "UPDATE T_DAVINCI_ANALISE_DISPOSITIVO SET potencia_registrada = ?, consumo_mensal = ?, classe_eficiencia = ? WHERE id_analise = ?";

        try {
            int rows = jdbcTemplate.update(sql, potenciaRegistrada, consumoMensal, classeEficiencia, id);
            return rows > 0 ? "Análise atualizada com sucesso!" : "Análise não encontrada.";
        } catch (Exception e) {
            return "Erro ao atualizar análise: " + e.getMessage();
        }
    }

    public String deletarAnalise(Long id) {
        String sql = "DELETE FROM T_DAVINCI_ANALISE_DISPOSITIVO WHERE id_analise = ?";

        try {
            int rows = jdbcTemplate.update(sql, id);
            return rows > 0 ? "Análise deletada com sucesso!" : "Análise não encontrada.";
        } catch (Exception e) {
            return "Erro ao deletar análise: " + e.getMessage();
        }
    }
}
