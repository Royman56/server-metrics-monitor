package com.uniminuto.server_metrics_monitor.repository;

import com.uniminuto.server_metrics_monitor.model.Servidor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServidorRepository extends JpaRepository<Servidor, Long> {
}
