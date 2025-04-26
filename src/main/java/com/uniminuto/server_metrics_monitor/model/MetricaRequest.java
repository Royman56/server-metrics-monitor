package com.uniminuto.server_metrics_monitor.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MetricaRequest {
    private Double cpuUso;
    private Double memoriaUso;
    private Double almacenamientoUso;
    private LocalDateTime fechaHora;
    private Long servidorId;
}
