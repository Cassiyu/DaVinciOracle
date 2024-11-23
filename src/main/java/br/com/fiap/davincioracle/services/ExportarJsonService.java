package br.com.fiap.davincioracle.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import java.sql.Clob;
import java.sql.SQLException;
import java.util.Map;

@Service
public class ExportarJsonService {

    private final JdbcTemplate jdbcTemplate;

    public ExportarJsonService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private String exportarJson(String procedureName) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName(procedureName)
                .declareParameters(new SqlOutParameter("p_json", java.sql.Types.CLOB));

        try {
            Map<String, Object> result = jdbcCall.execute();
            Clob clob = (Clob) result.get("p_json");
            if (clob != null) {
                return clob.getSubString(1, (int) clob.length());
            }
            return "[]"; // Retorna JSON vazio se o resultado for nulo
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao manipular CLOB: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao exportar JSON: " + e.getMessage(), e);
        }
    }

    public String exportarUsuariosJson() {
        return exportarJson("prc_exportar_usuarios_json");
    }

    public String exportarMedidoresJson() {
        return exportarJson("prc_exportar_medidores_json");
    }

    public String exportarDispositivosJson() {
        return exportarJson("prc_exportar_dispositivos_json");
    }

    public String exportarAnalisesJson() {
        return exportarJson("prc_exportar_analises_json");
    }

    public String exportarRelatoriosJson() {
        return exportarJson("prc_exportar_relatorios_json");
    }
}
