package com.juansoto.workshopmongo.services;

import com.juansoto.workshopmongo.domain.User;
import com.juansoto.workshopmongo.dto.UserDTO;
import com.juansoto.workshopmongo.repository.UserRepository;
import com.juansoto.workshopmongo.services.exception.ObjectNotFoundException;
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

    public User insert(User user){
        return repository.insert(user);
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User user){
        User newUser = findById(user.getId());
        updateData(newUser, user);
        return repository.save(user);
    }

    public void updateData (User userUpdate, User user){
        userUpdate.setName(user.getName());
        userUpdate.setEmail(user.getEmail());
    }

    //Criando o fromDTO no service pois em alguns casos pode precisar de acesso ao banco
    // e o service ja tem o repostitory, oque facilita a manutenção.
    public User fromDTO (UserDTO objDto){
       return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

}
