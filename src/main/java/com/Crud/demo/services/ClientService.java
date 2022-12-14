package com.Crud.demo.services;

import com.Crud.demo.entities.Clients;
import com.Crud.demo.repository.ClientRepository;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Clients save(Clients clients){
        return clientRepository.save(clients);
    }

    public List<Clients> ListClients(){
        return clientRepository.findAll();
    }
    public Optional<Clients> ListUniqClient(Long id){
        return clientRepository.findById(id);
    }

    public void removeId(Long id){
        clientRepository.deleteById(id);
    }
    public Clients UpdateById(Long id, Clients clients){
        return clientRepository.save(clients);
    }

}
