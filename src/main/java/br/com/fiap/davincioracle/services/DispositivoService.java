package br.com.fiap.davincioracle.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DispositivoService {

    private final JdbcTemplate jdbcTemplate;

    public DispositivoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String chamarProcedureInserirDispositivo(String nomeDispositivo, String tipoDispositivo, Double tempoUsoDiario,
                                                    Long idMedidor, Long idUsuario) {
        String sql = "{call prc_inserir_dispositivo(?, ?, ?, ?, ?, ?)}";

        try {
            jdbcTemplate.update(sql, nomeDispositivo, tipoDispositivo, tempoUsoDiario, idMedidor, idUsuario, null);
            return "Dispositivo inserido com sucesso!";
        } catch (Exception e) {
            return "Erro ao inserir dispositivo: " + e.getMessage();
        }
    }

    public List<Map<String, Object>> buscarTodosDispositivos() {
        String sql = "SELECT * FROM T_DAVINCI_DISPOSITIVOS";
        return jdbcTemplate.queryForList(sql);
    }

    public Map<String, Object> buscarDispositivoPorId(Long id) {
        String sql = "SELECT * FROM T_DAVINCI_DISPOSITIVOS WHERE id_dispositivo = ?";
        return jdbcTemplate.queryForMap(sql, id);
    }

    public String atualizarDispositivo(Long id, String nomeDispositivo, String tipoDispositivo, Double tempoUsoDiario) {
        String sql = "UPDATE T_DAVINCI_DISPOSITIVOS SET nm_dispositivo = ?, tp_dispositivo = ?, tmp_uso_diario = ? WHERE id_dispositivo = ?";

        try {
            int rows = jdbcTemplate.update(sql, nomeDispositivo, tipoDispositivo, tempoUsoDiario, id);
            return rows > 0 ? "Dispositivo atualizado com sucesso!" : "Dispositivo não encontrado.";
        } catch (Exception e) {
            return "Erro ao atualizar dispositivo: " + e.getMessage();
        }
    }

    public String deletarDispositivo(Long id) {
        String sql = "DELETE FROM T_DAVINCI_DISPOSITIVOS WHERE id_dispositivo = ?";

        try {
            int rows = jdbcTemplate.update(sql, id);
            return rows > 0 ? "Dispositivo deletado com sucesso!" : "Dispositivo não encontrado.";
        } catch (Exception e) {
            return "Erro ao deletar dispositivo: " + e.getMessage();
        }
    }
}
