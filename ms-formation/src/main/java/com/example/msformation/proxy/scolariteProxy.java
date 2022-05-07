package com.example.msformation.proxy;

import com.example.msformation.Models.Etudiant;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//une classe pour lire les entity des autres services
@FeignClient(name="ms-scolarite")
@LoadBalancerClient(name = "ms-scolarite")
public interface scolariteProxy {

    @GetMapping("/etudiants/search/findEtudiantByIdFormation")
    CollectionModel<Etudiant> getEtudinats(@RequestParam("idf") Long idf,
                                                  @RequestParam("projection") String p);
}
