package com.epiq.persistence.respositories;


import com.epiq.persistence.entities.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IDevisRepository extends JpaRepository<Devis,Long>{
}
