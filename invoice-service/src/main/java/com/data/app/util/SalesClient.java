package com.data.app.util;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "sale-service")
@RibbonClient(name = "sale-service")
public interface SalesClient {

    @GetMapping("v1/sale/{id}")
    ResponseEntity<?> getSales(@PathVariable("id") Integer id);
}
  