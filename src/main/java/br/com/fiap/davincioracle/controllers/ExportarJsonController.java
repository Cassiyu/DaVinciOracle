package br.com.fiap.davincioracle.controllers;

import br.com.fiap.davincioracle.services.ExportarJsonService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/exportar")
public class ExportarJsonController {

    private final ExportarJsonService exportarJsonService;

    public ExportarJsonController(ExportarJsonService exportarJsonService) {
        this.exportarJsonService = exportarJsonService;
    }

    @GetMapping("/usuarios")
    public ResponseEntity<byte[]> exportarUsuariosJson() {
        String json = exportarJsonService.exportarUsuariosJson();
        byte[] jsonBytes = json.getBytes(StandardCharsets.UTF_8);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=usuarios.json");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

        return new ResponseEntity<>(jsonBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/medidores")
    public ResponseEntity<byte[]> exportarMedidoresJson() {
        String json = exportarJsonService.exportarMedidoresJson();
        byte[] jsonBytes = json.getBytes(StandardCharsets.UTF_8);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=medidores.json");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

        return new ResponseEntity<>(jsonBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/dispositivos")
    public ResponseEntity<byte[]> exportarDispositivosJson() {
        String json = exportarJsonService.exportarDispositivosJson();
        byte[] jsonBytes = json.getBytes(StandardCharsets.UTF_8);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=dispositivos.json");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

        return new ResponseEntity<>(jsonBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/analises")
    public ResponseEntity<byte[]> exportarAnalisesJson() {
        String json = exportarJsonService.exportarAnalisesJson();
        byte[] jsonBytes = json.getBytes(StandardCharsets.UTF_8);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=analises.json");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

        return new ResponseEntity<>(jsonBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/relatorios")
    public ResponseEntity<byte[]> exportarRelatoriosJson() {
        String json = exportarJsonService.exportarRelatoriosJson();
        byte[] jsonBytes = json.getBytes(StandardCharsets.UTF_8);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=relatorios.json");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

        return new ResponseEntity<>(jsonBytes, headers, HttpStatus.OK);
    }
}
