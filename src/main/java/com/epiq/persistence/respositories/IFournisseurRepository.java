package com.epiq.persistence.respositories;

import org.springframework.stereotype.Repository;
import com.epiq.persistence.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;



@Repository
public interface IFournisseurRepository extends JpaRepository<Fournisseur,Long> {
}
