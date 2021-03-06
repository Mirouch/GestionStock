package com.epiq.controllers;


import com.epiq.persistence.entities.Product;
import com.epiq.persistence.respositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
public class ProductController {

    @Autowired(required = true)
    private IProductRepository productRepository;


   /* @RequestMapping(value = "/products",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Product add(@RequestBody Product p) {
        productRepository.save(p);
        return p;
    }
    */
   @RequestMapping(value = "/products", method = RequestMethod.POST,headers="Accept=application/json")

   public Product add(@RequestBody Product p) {
       System.out.println("erreur");
       productRepository.save(p);
       return p;
   }



   @RequestMapping(value = "/products/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Product update(@RequestBody Product p, @PathVariable("id") long id) {
        Product product = productRepository.findOne(id);
        product.updateWith(p);
        return productRepository.save(product);
    }

    @RequestMapping(value = "/products/{id}",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProduct(@PathVariable("id") long id) {
        return productRepository.findOne(id);

    }

    @RequestMapping(value = "/products",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> listProduct() {
        return productRepository.findAll();

    }


   /*
   @RequestMapping(value = "/products", method = RequestMethod.GET,headers="Accept=application/json")
    public List<Product> listProduct() {
        return productRepository.findAll();

    }
   */



    @RequestMapping(value = "/products/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") long id) {
        productRepository.delete(id);


    }}

    /*
    @RequestMapping(value = "/products/{dateEntree}{dateSortie}",
                    method = RequestMethod.Get,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product>(@PathVariable("id")  Date dateEntree, Date dateSortie) {
        productRepository.findProductByDates(dateEntree,dateSortie);

   }
    */


