package com.example.library.service;

import com.example.library.model.Task;
import com.example.library.model.Book;
import com.example.library.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public List<Task> findByBook(Book book) {
        return taskRepository.findByBook(book);
    }

    @Transactional
    public Task save(Task task) {
        return taskRepository.save(task);
    }
}
