package com.example.kanbansystem.Controller;
import com.example.kanbansystem.controller.SprintController;
import com.example.kanbansystem.entities.Sprint;
import com.example.kanbansystem.service.SprintService;
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
public class TestSprintController {
    @Mock
    private SprintService sprintService;
    @InjectMocks
    private SprintController sprintController;

    @Test
    public void testGetSprintByName() {
        String sprintName = "sprint 1";
        List<Sprint> mockSprints = new ArrayList<>();
        when(sprintService.getSprintByName(sprintName)).thenReturn(mockSprints);
        ResponseEntity<List<Sprint>> responseEntity = sprintController.getTaskByName(sprintName);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockSprints, responseEntity.getBody());
    }

    @Test
    public void testGetSprintById() {
        Long sprintId = 1L;
        Optional<Sprint> mockOptionalSprint = Optional.of(new Sprint());
        when(sprintService.getSprintById(sprintId)).thenReturn(mockOptionalSprint);
        ResponseEntity<Sprint> responseEntity = sprintController.getsprintById(sprintId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockOptionalSprint.get(), responseEntity.getBody());
    }

    @Test
    public void testGetAllSprint() {
        List<Sprint> mockSprints = new ArrayList<>();
        when(sprintService.getAllSprint()).thenReturn(mockSprints);
        ResponseEntity<List<Sprint>> responseEntity = sprintController.getAllSprint();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockSprints, responseEntity.getBody());
    }

    @Test
    public void testSaveSprint() {
        Sprint mockSprint = new Sprint();
        when(sprintService.saveSprint(any(Sprint.class))).thenReturn(mockSprint);
        ResponseEntity<Sprint> responseEntity = sprintController.saveSprint(mockSprint);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(mockSprint, responseEntity.getBody());
    }

    @Test
    public void testDeleteSprintById() {
        Long sprintId = 1L;
        String expectedResult = "Deleted";
        when(sprintService.deleteSprintById(sprintId)).thenReturn(expectedResult);
        ResponseEntity<String> responseEntity = sprintController.deleteSprintById(sprintId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResult, responseEntity.getBody());
    }
}
