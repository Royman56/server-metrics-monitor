package com.uniminuto.server_metrics_monitor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/api/login")
    public ResponseEntity<String> login() {
        return new ResponseEntity<>("Login exitoso.", HttpStatus.OK);
    }
}

