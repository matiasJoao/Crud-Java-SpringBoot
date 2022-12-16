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
    public String save(@RequestBody Clients clients) {
       String email = clients.getEmail();
       String cpf = clients.getCpf();
       String name = clients.getName();
       return clientService.verifyEmailCpfName(email, cpf, name, clients);
    }

    @GetMapping
    public List<Clients> ListClients() {
        return clientService.ListClients();
    }

    @GetMapping("/{id}")
    public Clients SearchId(@PathVariable("id") Long id) {
        return clientService.ListUniqClient(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente Não Encontrado"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Clients Update(@PathVariable("id") Long id, @RequestBody Clients clients) {
        return clientService.UpdateById(id, clients);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public  String delete( @PathVariable  Long id) {
        SearchId(id);
       return clientService.delete(id);
    }
    @PatchMapping("/{id}/{email}")
    public Clients UpdateEmail(@PathVariable("id") Long id, @PathVariable("email") String email){
       Clients clients = SearchId(id);
       clients.setEmail(email);
       return clientService.save(clients);
    }
}
