package com.caioleo.todosimple.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = User.TABLE_NAME)

public class User {
    public interface CreateUser {
    }

    public interface UpdateUser {
    }

    public static final String TABLE_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)

    private Long id;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "username", length = 100, nullable = false, unique = true)
    @NotNull(groups = CreateUser.class) // *? Não pode ser nulo
    @NotEmpty(groups = CreateUser.class) // *? Não pode ser vazio
    @Size(groups = CreateUser.class, min = 2, max = 100) // *? Tem que está dentro do parâmetro
    private String username;

    @Column(name = "password", length = 60, nullable = false)
    @NotNull(groups = { CreateUser.class, UpdateUser.class })
    @NotEmpty(groups = { CreateUser.class, UpdateUser.class })
    @Size(groups = { CreateUser.class, UpdateUser.class }, min = 8, max = 60)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks = new ArrayList<Task>();

    public User() {

    }

    public User(Long id, String username, String password) {
        this.id = id;
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

    @JsonIgnore
    public List<Task> getTasks() {
        return this.tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    @Override
public boolean equals(Object obj) {
    if (obj == this) {
        return true;  // Se os objetos forem o mesmo, retorna true
    }
    if (obj == null) {
        return false; // Se o objeto comparado for nulo, retorna false
    }
    if (!(obj instanceof User)) {
        return false; // Se o objeto não for uma instância de User, retorna false
    }

    User other = (User) obj; // Faz o cast do objeto para a classe User

    // Verifica se o id é diferente entre os objetos
    if (this.id != null) {
        if (other.id == null) {
            return false; // Se um id é nulo e o outro não, retorna false
        } else if (!this.id.equals(other.id)) {
            return false; // Se os ids forem diferentes, retorna false
        }
    }

    // Retorna true se os ids forem iguais ou ambos nulos
    return Objects.equals(this.id, other.id) && Objects.equals(this.username, other.username) && Objects.equals(this.password, other.password);
}

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
    return result;  // Retorna apenas o código de hash do id, como no seu código original
}


}
