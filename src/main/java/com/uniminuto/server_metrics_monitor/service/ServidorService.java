package com.uniminuto.server_metrics_monitor.service;

import com.uniminuto.server_metrics_monitor.model.Servidor;
import com.uniminuto.server_metrics_monitor.repository.ServidorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServidorService {
    private final ServidorRepository servidorRepository;

    public ServidorService(ServidorRepository servidorRepository) {
        this.servidorRepository = servidorRepository;
    }

    public Servidor guardar(Servidor servidor) {
        return servidorRepository.save(servidor);
    }

    public List<Servidor> listar() {
        return servidorRepository.findAll();
    }

    public Servidor obtenerPorId(Long id) {
        return servidorRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        servidorRepository.deleteById(id);
    }
}
