package com.uniminuto.server_metrics_monitor.repository;

import com.uniminuto.server_metrics_monitor.model.Metrica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MetricaRepository extends JpaRepository<Metrica, Long> {
    List<Metrica> findByServidorId(Long servidorId);
}
