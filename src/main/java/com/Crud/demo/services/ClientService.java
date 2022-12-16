package com.Crud.demo.services;

import com.Crud.demo.entities.Clients;
import com.Crud.demo.helpers.RegexHelper;
import com.Crud.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public Clients UpdateById(Long id, Clients clients){
        return clientRepository.save(clients);
    }
    public void delete(Long id){
        clientRepository.deleteById(id);
    }

    public String emailVerify(String email, Clients clients){
        Boolean verify;
        String msg;
        RegexHelper regexHelper = new RegexHelper();
        verify = regexHelper.email(email);
        if(verify){
            msg = "Cadastrado com sucesso";
            clientRepository.save(clients);
        }
        else {
            msg = "Email invalido";
        }
        return msg;
    }


}
