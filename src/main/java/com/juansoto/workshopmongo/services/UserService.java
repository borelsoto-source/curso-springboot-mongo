package com.juansoto.workshopmongo.services;

import com.juansoto.workshopmongo.domain.User;
import com.juansoto.workshopmongo.repository.UserRepository;
import com.juansoto.workshopmongo.services.exception.ObjectNotFoundException;
import com.sun.jdi.ObjectCollectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        return repository.findById(id)
            .orElseThrow(()-> new ObjectNotFoundException("Usuario nao encontrado para o id: "+id));
    }
}
