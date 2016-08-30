package com.epiq.controllers;

import com.epiq.persistence.entities.Devis;
import com.epiq.persistence.respositories.IDevisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DevisController {

    @Autowired(required = true)
    private IDevisRepository devisRepository;



    @RequestMapping(value="/devis",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Devis add(@RequestBody Devis devis){
        devisRepository.save(devis);
        return devis;
    }


    @RequestMapping(value="/devis/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Devis update(@RequestBody Devis d, @PathVariable("id") long id){
        Devis devis = devisRepository.findOne(id);
        devis.updateWith(d);
        return devisRepository.save(devis);
    }


    @RequestMapping(value="/devis/{id}",
            method=RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Devis getDevis(@PathVariable("id") long id) {
        return devisRepository.findOne(id);

    }


    @RequestMapping(value="/devis",
            method=RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Devis> listDevis() {
        return  devisRepository.findAll();

    }


    @RequestMapping(value="/devis/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") long id) {
       devisRepository.delete(id);

    }


}
