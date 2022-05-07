package com.example.msformation.Repo;

import com.example.msformation.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
//on declare une api dans repo pour des requete qui ont une relation avec la table formation
public interface FormationRepository extends JpaRepository<Formation,Long> {
}
