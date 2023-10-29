package com.devsu.accounts.client;

import com.devsu.accounts.model.dto.ClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "client-service", url = "http://your-service-hostname:port")
public interface ClientServiceFeignClient {

    @GetMapping("/api/v1/clients/{id}")
    ClientDto getById(@PathVariable("id") Long id);

}
