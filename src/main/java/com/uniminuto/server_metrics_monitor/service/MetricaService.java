package com.uniminuto.server_metrics_monitor.service;

import com.uniminuto.server_metrics_monitor.model.Metrica;
import com.uniminuto.server_metrics_monitor.repository.MetricaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricaService {
    private final MetricaRepository metricaRepository;

    public MetricaService(MetricaRepository metricaRepository) {
        this.metricaRepository = metricaRepository;
    }

    public Metrica guardar(Metrica metrica) {
        return metricaRepository.save(metrica);
    }

    public List<Metrica> listarPorServidor(Long servidorId) {
        return metricaRepository.findByServidorId(servidorId);
    }
}
