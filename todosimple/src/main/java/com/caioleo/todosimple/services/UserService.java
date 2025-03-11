package com.caioleo.todosimple.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.caioleo.todosimple.repositories.UserRepository;
import com.caioleo.todosimple.models.User;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

  



    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);  // Busca o usuário no banco de dados
        return user.orElseThrow(() -> new RuntimeException(  // Lança exceção se não encontrado
            "Usuario nao encontrado! Id: " + id + ", Tipo: " + User.class.getName()
        ));
    }
    
   

    @Transactional
    public User create(User obj) {
        obj.setId(null);
        obj = this.userRepository.save(obj);
        return obj;
    }

    @Transactional
    public User update(User obj) {
       User newObj = findById(obj.getId());
       newObj.setPassword(obj.getPassword());
       return this.userRepository.save(newObj);
    }

    public void delete  (Long id) {
        findById(id);
        try {
            this.userRepository.deleteById(id);
        } catch (Exception e) {
           throw new RuntimeException("Não é possivel excluir pois há entidade relacionadas!");
        }
    }

}


