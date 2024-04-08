package com.example.kanbansystem.controller;

import com.example.kanbansystem.entities.Task;
import com.example.kanbansystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping("/tasks/{taskName}")
    public ResponseEntity<List<Task>> getTaskByName(@PathVariable("taskName") String taskName) {
        List<Task> task = taskService.getTaskByName(taskName);
        if (task != null) {
            return new ResponseEntity<>(task, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
     @GetMapping("/tasksId/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable("taskId") Long taskId) {
        Optional<Task> task = taskService.getTaskById(taskId);
        if (task.isPresent()) {
            return new ResponseEntity<>(task.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTask() {
        List<Task> tasks = taskService.getAllTask();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
    @PostMapping("/tasks")
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        Task savedTask = taskService.saveTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/delete_tasks/{taskId}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public ResponseEntity<String> deleteTaskById(@PathVariable("taskId") Long taskId) {
        String result = taskService.deleteTaskById(taskId);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
