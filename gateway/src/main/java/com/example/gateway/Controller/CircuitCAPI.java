package com.example.gateway.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CircuitCAPI {
    @GetMapping("/defaultFormations")
    public List<Formation> getDefaultFormation(){
        List<Formation> formations = new ArrayList<>();
        formations.add(new Formation("PHP",10));
        formations.add(new Formation("Angular",10));
        return formations;
    }
}
