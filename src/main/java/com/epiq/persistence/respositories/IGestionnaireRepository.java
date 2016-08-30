package com.epiq.persistence.respositories;

import com.epiq.persistence.entities.Gestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IGestionnaireRepository extends JpaRepository<Gestionnaire,Long> {



    }