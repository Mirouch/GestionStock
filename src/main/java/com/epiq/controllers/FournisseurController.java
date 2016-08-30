package com.epiq.controllers;

import com.epiq.persistence.entities.Fournisseur;
import com.epiq.persistence.respositories.IFournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
  public class FournisseurController {


     @Autowired(required = true)
        private IFournisseurRepository fournisseurRepository;



    @RequestMapping(value = "/fournisseurs",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Fournisseur add(@RequestBody Fournisseur fournisseur){
        fournisseurRepository.save(fournisseur);
        return fournisseur;
    }



    @RequestMapping(value="/fournisseurs/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Fournisseur update(@RequestBody Fournisseur f, @PathVariable("id") long id){
        Fournisseur fournisseur = fournisseurRepository.findOne(id);
        fournisseur.updateWith(f);
        return fournisseurRepository.save(fournisseur);
    }



    @RequestMapping(value="/fournisseurs/{id}",
            method=RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Fournisseur getFournisseur(@PathVariable("id") long id) {
        return fournisseurRepository.findOne(id);
    }



    @RequestMapping(value="/fournisseurs",
            method=RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Fournisseur> listFournisseur() {
        return  fournisseurRepository.findAll();

    }


    @RequestMapping(value="/fournisseurs/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") long id) {
       fournisseurRepository.delete(id);

    }



}
