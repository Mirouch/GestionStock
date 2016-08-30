package com.epiq.controllers;


import com.epiq.persistence.entities.Gestionnaire;
import com.epiq.persistence.respositories.IGestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class GestionnaireController {


    @Autowired(required = true)
    private IGestionnaireRepository gestionnaireRepository;


    @RequestMapping(value="/gestionnaires",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Gestionnaire add(@RequestBody Gestionnaire gestionnaire){
        gestionnaireRepository.save(gestionnaire);
        return gestionnaire;
    }

    @RequestMapping(value="/gestionnaires/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Gestionnaire update(@RequestBody Gestionnaire g, @PathVariable("id") long id){
        Gestionnaire gestionnaire= gestionnaireRepository.findOne(id);
        gestionnaire.updateWith(g);
        return gestionnaireRepository.save(gestionnaire);
    }


    @RequestMapping(value="/gestionnaires/{id}",
            method=RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Gestionnaire getGestionnaire(@PathVariable("id") long id) {
        return  gestionnaireRepository.findOne(id);
    }


    @RequestMapping(value="/gestionnaires",
            method=RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Gestionnaire> listGestionnaire() {
        return  gestionnaireRepository.findAll();
    }


    @RequestMapping(value="/gestionnaires/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") long id) {
        gestionnaireRepository.delete(id);

    }


}
