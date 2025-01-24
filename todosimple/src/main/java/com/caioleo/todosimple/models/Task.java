package com.caioleo.todosimple.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = Task.TABLE_NAME)
public class Task {
    public static final String TABLE_NAME = "task";
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable =  false, updatable = false)
    private User user;

    @Column(name = "description", length = 255, nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String description;


    public Task() {
    }

    public Task(Long id, User user, String description) {
        this.id = id;
        this.user = user;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task id(Long id) {
        setId(id);
        return this;
    }

    public Task user(User user) {
        setUser(user);
        return this;
    }

    public Task description(String description) {
        setDescription(description);
        return this;
    }

    @Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;  // Se os objetos forem o mesmo, retorna true
    }
    if (obj == null) {
        return false; // Se o objeto comparado for nulo, retorna false
    }
    if (!(obj instanceof Task)) {
        return false; // Se o objeto não for uma instância de Task, retorna false
    }

    Task other = (Task) obj; // Faz o cast do objeto para a classe Task

    // Verifica se o id é diferente entre os objetos
    if (this.id != null) {
        if (other.id == null) {
            return false; // Se um id é nulo e o outro não, retorna false
        } else if (!this.id.equals(other.id)) {
            return false; // Se os ids forem diferentes, retorna false
        }
    }

    // Retorna true se os ids forem iguais ou ambos nulos
    return this.username.equals(other.username) && this.password.equals(other.password);
}

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
    return result;  // Retorna apenas o código de hash do id, como no seu código original
}
   
}
