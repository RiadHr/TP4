package com.example.msscolarite.proxy;

import com.example.msscolarite.Model.Formation;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ms-formation")
@LoadBalancerClient(name="ms-formation")
public interface FormationProxy {

    @GetMapping("formations/{idf}")
    @CircuitBreaker(name="fall1",fallbackMethod ="fallbackformation")
    Formation getFormation(@PathVariable("idf") Long idf);

    default Formation fallbackFormation(Throwable throwable){
        return new Formation("java",90);
    }

}


