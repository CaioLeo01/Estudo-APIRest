package com.caioleo.todosimple.models;


import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
@Table (name = User.TABLE_NAME)

public class User {
    public interface CreateUser{}
    public interface UpdateUser{}
    public static final String TABLE_NAME = "user";
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", unique = true)

    private Long id;

    @Column(name = "username", length = 100, nullable = false, unique = true)
    @NotNull(groups = CreateUser.class)                  // *? Não pode ser nulo 
    @NotEmpty(groups = CreateUser.class)                // *? Não pode ser vazio 
    @Size(groups = CreateUser.class,min = 2, max = 100) // *? Tem que está dentro do parâmetro  
    private String username;

    @Column(name = "password", length = 60,nullable = false)
    @NotNull(groups = {CreateUser.class, UpdateUser.class})  
    @NotEmpty(groups = {CreateUser.class, UpdateUser.class})
    @Size(groups = {CreateUser.class, UpdateUser.class},min= 8, max = 60)
    private String password;




    //private List<Task> tasks = new ArrayList<Task>();

    public User (){

    }

    public User (Long id, String username, String password) {
        this.id=id;
        this.username = username;
        this.password = password; 


    }



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals (object o) {

        if (o == this) 
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Onjects.equals(id, user.id) && Objects.equals(username, user.username) && Object





    }
    
    

}



