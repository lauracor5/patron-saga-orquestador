package com.laura.msvc_orchestrator.controllers;

import com.laura.msvc_orchestrator.models.ExecuteSagaResponse;
import com.laura.msvc_orchestrator.models.orders.OrderDTO;
import com.laura.msvc_orchestrator.services.ExecuteSagaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/execute/process")
public class OrderController {

    private final ExecuteSagaService executeSagaService;

    public OrderController(ExecuteSagaService executeSagaService) {
        this.executeSagaService = executeSagaService;
    }

    @PostMapping
    public ResponseEntity<ExecuteSagaResponse>executeProcess(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(executeSagaService.executionProcessSaga(orderDTO));

    }

}
