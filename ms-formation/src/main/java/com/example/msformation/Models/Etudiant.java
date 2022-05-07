package com.example.msformation.Models;

import lombok.Data;
/*cette classe est juste pour le parsing exp parsing des data depuis un micserv node js vers micserv spingboot */
@Data
public class Etudiant {
    private String nomEtudiant;
    private String nomEtablissement;
}