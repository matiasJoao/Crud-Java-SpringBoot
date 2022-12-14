package com.Crud.demo.controller;

import com.Crud.demo.entities.Clients;
import com.Crud.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Clients save(@RequestBody Clients clients){
        return clientService.save(clients);
    }
    @GetMapping
    public List<Clients> ListClients(){
        return clientService.ListClients();
    }
    @GetMapping("/{id}")
    public Clients SearchId(@PathVariable("id") Long id){
       return clientService.ListUniqClient(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente Não Encontrado"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Clients Update(@PathVariable("id") Long id, @RequestBody Clients clients){
        return clientService.UpdateById(id, clients);
    }
}
