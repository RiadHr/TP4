package com.example.msscolarite.Repositories;

import com.example.msscolarite.entities.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {
}