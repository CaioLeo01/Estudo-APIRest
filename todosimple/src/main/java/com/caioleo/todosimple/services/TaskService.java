package com.caioleo.todosimple.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.caioleo.todosimple.models.User;
import com.caioleo.todosimple.repositories.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;


    @Autowired
    private UserService userService;

    public Task findById(Long id) {

        Optional<Task> task = this.taskRepository.findById(id);
        return task.orElseThrow(() -> new RuntimeException(
        "Tarefa não encontrado! Id" + id + ", Tipo: " + Task.class.getName() ));
    }
        
    public Task create (Task obj){
        User user - this.userService.findById(obj.getUser().getId());
    }
    
}
