package com.uniminuto.server_metrics_monitor.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ServidorRequest {
    private String nombre;
    private String ip;
    private String sistemaOperativo;
    private LocalDate fechaRegistro;
}
