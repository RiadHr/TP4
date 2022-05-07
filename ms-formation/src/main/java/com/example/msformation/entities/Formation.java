package com.example.msformation.entities;

//import com.example.msformation.models.Etudiant;
import com.example.msformation.Models.Etudiant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFormation;
    private String nom;
    private int duree;


    //attribut qui n est pas dans la table mais on n utilse pour faire des traitments
    @Transient
    private Collection<Etudiant> etudiants;
}
