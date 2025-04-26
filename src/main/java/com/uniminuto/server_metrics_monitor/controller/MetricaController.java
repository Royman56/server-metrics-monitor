package com.uniminuto.server_metrics_monitor.controller;

import com.uniminuto.server_metrics_monitor.model.Metrica;
import com.uniminuto.server_metrics_monitor.model.MetricaRequest;
import com.uniminuto.server_metrics_monitor.model.Servidor;
import com.uniminuto.server_metrics_monitor.service.MetricaService;
import com.uniminuto.server_metrics_monitor.service.ServidorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metricas")
@RequiredArgsConstructor
public class MetricaController {

    private final MetricaService metricaService;
    private final ServidorService servidorService;

    @PostMapping
    public ResponseEntity<Metrica> crear(@RequestBody MetricaRequest request) {
        Servidor servidor = servidorService.obtenerPorId(request.getServidorId());
        if (servidor == null) {
            return ResponseEntity.badRequest().build();
        }

        Metrica metrica = new Metrica();
        metrica.setCpuUso(request.getCpuUso());
        metrica.setMemoriaUso(request.getMemoriaUso());
        metrica.setAlmacenamientoUso(request.getAlmacenamientoUso());
        metrica.setFechaHora(request.getFechaHora());
        metrica.setServidor(servidor);

        return ResponseEntity.ok(metricaService.guardar(metrica));
    }

    @GetMapping("/servidor/{id}")
    public ResponseEntity<List<Metrica>> listarPorServidor(@PathVariable Long id) {
        return new ResponseEntity<>(metricaService.listarPorServidor(id), HttpStatus.OK);
    }
}
