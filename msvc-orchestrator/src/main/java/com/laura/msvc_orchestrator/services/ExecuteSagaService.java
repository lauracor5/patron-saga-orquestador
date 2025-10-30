package com.laura.msvc_orchestrator.services;

import com.laura.msvc_orchestrator.models.ExecuteSagaResponse;
import com.laura.msvc_orchestrator.models.orders.OrderDTO;

public interface ExecuteSagaService {

   ExecuteSagaResponse executionProcessSaga(OrderDTO orderDTO);
}
