package com.laura.msvc_orchestrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsvcOrchestratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcOrchestratorApplication.class, args);
	}

}
