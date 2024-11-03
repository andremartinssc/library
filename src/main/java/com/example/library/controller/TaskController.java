package com.example.library.controller;

import com.example.library.model.Task;
import com.example.library.model.Book;
import com.example.library.service.TaskService;
import com.example.library.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;
    private final BookService bookService;

    public TaskController(TaskService taskService, BookService bookService) {
        this.taskService = taskService;
        this.bookService = bookService;
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Task>> getTasksByBook(@PathVariable Long bookId) {
        Book book = bookService.findById(bookId).orElse(null);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        List<Task> tasks = taskService.findByBook(book);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.save(task);
    }
}
