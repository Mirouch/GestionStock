package com.epiq.persistence.respositories;

import com.epiq.persistence.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface IProductRepository extends JpaRepository<Product,Long>{

   /* @Query("SELECT p FROM  Product P WHERE :theDate between p.dateEntree and p.dateSortie")
        List<Product> findProductByDates(Date  theDate);  */

    }


    // @Query("Select p from Product p where p.name like :x")
     // public Page<Product> productbymc(@Param("x")String mc, Pageable p);
      //public List<Product> findByNom_Produit(String NomP);
     // public Page<Product> findByNom_Produit(String NomP, Pageable p);

    //Product findByName(String NOM_PRODUIT);
    //Product findByQuantitePhysique(int qte);

    //Integer deleteByName(String NOM_PRODUIT);

    //void delete(String NOM_PRODUIT);//



