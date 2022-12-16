package com.Crud.demo.services;

import com.Crud.demo.entities.Clients;
import com.Crud.demo.helpers.RegexHelper;
import com.Crud.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public String  delete(Long id){
        clientRepository.deleteById(id);
        String msg = "deletado com sucesso";
        return msg;
    }

    public String verifyEmailCpfName(String email, String cpf, String name, Clients clients){

        Boolean verifyEmail, verifyCpf, verifyName ;
        String msg;

        RegexHelper regexHelper = new RegexHelper();

        verifyName = regexHelper.nomeValidation(name);
        verifyEmail = regexHelper.email(email);
        verifyCpf = regexHelper.cpfValidation(cpf);

        if(verifyEmail && verifyCpf && verifyName){
            msg = "Cadastrado com sucesso";
            clientRepository.save(clients);
        }
        else {
            msg = "Email invalido ou Cpf invalido ou Nome invalido";
        }

        return msg;
    }



}
