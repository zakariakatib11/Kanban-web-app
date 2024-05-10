package com.example.kanbansystem.Controller;
import com.example.kanbansystem.controller.TaskController;
import com.example.kanbansystem.entities.Task;
import com.example.kanbansystem.entities.TaskStatus;
import com.example.kanbansystem.service.EmailService;
import com.example.kanbansystem.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestTaskController {
    @Mock
    private TaskService taskService;
    @Mock
    private EmailService emailService;
    @InjectMocks
    private TaskController taskController;

    @Test
    public void testGetTaskByName() {
        String taskName = "task 1";
        List<Task> mockTasks = new ArrayList<>();
        when(taskService.getTaskByName(taskName)).thenReturn(mockTasks);
        ResponseEntity<List<Task>> responseEntity = taskController.getTaskByName(taskName);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockTasks, responseEntity.getBody());
    }
    @Test
    public void testGetTaskById() {
        Long taskId = 1L;
        Optional<Task> mockOptionalTask = Optional.of(new Task());
        when(taskService.getTaskById(taskId)).thenReturn(mockOptionalTask);
        ResponseEntity<Task> responseEntity = taskController.getTaskById(taskId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockOptionalTask.get(), responseEntity.getBody());
    }
    @Test
    public void testGetAllTask() {
        List<Task> mockTasks = new ArrayList<>();
        when(taskService.getAllTask()).thenReturn(mockTasks);
        ResponseEntity<List<Task>> responseEntity = taskController.getAllTask();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockTasks, responseEntity.getBody());
    }
    @Test
    public void testSaveTask() {
        Task mockTask = new Task();
        when(taskService.saveTask(any(Task.class))).thenReturn(mockTask);
        ResponseEntity<Task> responseEntity = taskController.saveTask(mockTask);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(mockTask, responseEntity.getBody());
    }
    @Test
    public void testDeleteTaskById() {
        Long taskId = 1L;
        String expectedResult = "Deleted";
        when(taskService.deleteTaskById(taskId)).thenReturn(expectedResult);
        ResponseEntity<String> responseEntity = taskController.deleteTaskById(taskId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResult, responseEntity.getBody());
    }
    @Test
    public void testUpdateTaskStatus() {
        Long taskId = 1L;
        TaskStatus status = TaskStatus.IN_PROGRESS;
        doNothing().when(taskService).updateTaskStatus(taskId, status);
        ResponseEntity<?> responseEntity = taskController.updateTaskStatus(taskId, status);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
