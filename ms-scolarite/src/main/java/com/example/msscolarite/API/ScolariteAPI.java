package com.example.msscolarite.API;

import com.example.msscolarite.Repositories.EtudiantRepository;
import com.example.msscolarite.entities.Etudiant;
import com.example.msscolarite.proxy.FormationProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ScolariteAPI {
    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    FormationProxy formationProxy;

    @GetMapping("etudiants/{id}")
        Etudiant getEtudiantWithFormation(@PathVariable("id") Long ide){
            Etudiant etudiant = etudiantRepository.findById(ide).get();
            etudiant.setFormation(
                    formationProxy.getFormation(etudiant.getIdFormation()));

            return etudiant;
        }



    @GetMapping("etudiants")
    List<Etudiant> GetEtudiantswithFormation(){
        List<Etudiant> etudiants = etudiantRepository.findAll();
        etudiants.forEach((e)->{
            e.setFormation(formationProxy.getFormation(e.getIdFormation()));
                });
        return etudiants;
    }
}