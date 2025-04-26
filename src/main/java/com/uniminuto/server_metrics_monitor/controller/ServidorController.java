package com.uniminuto.server_metrics_monitor.controller;

import com.uniminuto.server_metrics_monitor.model.Servidor;
import com.uniminuto.server_metrics_monitor.model.ServidorRequest;
import com.uniminuto.server_metrics_monitor.service.ServidorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servidores")
@RequiredArgsConstructor
public class ServidorController {

    private final ServidorService servidorService;

    @PostMapping
    public ResponseEntity<Servidor> crear(@RequestBody ServidorRequest request) {
        Servidor servidor = new Servidor();
        servidor.setNombre(request.getNombre());
        servidor.setIp(request.getIp());
        servidor.setSistemaOperativo(request.getSistemaOperativo());
        servidor.setFechaRegistro(request.getFechaRegistro());

        return new ResponseEntity<>(servidorService.guardar(servidor), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Servidor>> listar() {
        return new ResponseEntity<>(servidorService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servidor> obtener(@PathVariable Long id) {
        return new ResponseEntity<>(servidorService.obtenerPorId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servidorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}