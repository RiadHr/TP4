package com.example.msformation.Controller;

import com.example.msformation.Repo.FormationRepository;
import com.example.msformation.entities.Formation;
import com.example.msformation.proxy.scolariteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api")
@RefreshScope
public class FormationAPI {

    @Autowired
    FormationRepository formationRepository;

    @Autowired
    scolariteProxy scolariteproxy;

    @Value("${mes-config.email}")
    private String email;

    @GetMapping("email")
    public String getEmail(){
        return email;
    }


    //on utilse ces requete pour une requete combinerpour plusieurs info
    @GetMapping("formation/{id}")
    Formation getFormationWithStudent(@PathVariable("id") Long idf)
    {
        Formation formation=formationRepository.findById(idf).get();
        formation.setEtudiants(
                new ArrayList<>(scolariteproxy.getEtudinats(idf,"toformation").getContent()));
        return formation;
    }
}
