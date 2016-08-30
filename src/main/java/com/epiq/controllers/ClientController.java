package com.epiq.controllers;


import com.epiq.persistence.entities.Client;
import com.epiq.persistence.respositories.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ClientController {

    @Autowired(required = true)
    private IClientRepository clientRepository;


    @RequestMapping(value="/clients",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Client add(@RequestBody Client client){
        clientRepository.save(client);
        return client;
    }



    @RequestMapping(value="/clients/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Client update(@RequestBody Client c, @PathVariable("id") long id){
        Client client = clientRepository.findOne(id);
        client.updateWith(c);
        return clientRepository.save(client);
    }



    @RequestMapping(value="/clients/{id}",
            method=RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Client getClient(@PathVariable("id") long id) {
        return  clientRepository.findOne(id);
    }



    @RequestMapping(value="/clients",
            method=RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Client> listClient() {
        return  clientRepository.findAll();

    }


    @RequestMapping(value="/clients/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") long id) {
        clientRepository.delete(id);

    }

}
