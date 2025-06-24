package com.expertise.ebudget.budget.entity.center;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;

@FeignClient(name = "center-service", url = "${application.config.center-url}")
public interface CenterClient {

    @GetMapping("/{centerId}")
    Optional<CenterResponse> findById(@PathVariable("centerId") Long centerId);

    @PutMapping
    void updateCenter(CenterResponse request);


}
