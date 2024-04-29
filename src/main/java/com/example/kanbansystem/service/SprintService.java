package com.example.kanbansystem.service;

import com.example.kanbansystem.Repository.SprintRepository;
import com.example.kanbansystem.entities.Sprint;
import com.example.kanbansystem.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SprintService {

    @Autowired
    private SprintRepository sprintRepository;
    public Sprint saveSprint(Sprint sprint) {
        return sprintRepository.save(sprint);
    }
    public Optional<Sprint> getSprintById(long id) {
        return sprintRepository.findById(id);
    }
    public List<Sprint> getAllSprint() {
        return sprintRepository.findAll();
    }
    public List<Sprint> getSprintByName(String name){return sprintRepository.findSprintByName(name);}
    public String deleteSprintById(Long id){
        sprintRepository.deleteById(id);
        return "Sprint with id "+id+" deleted successfully!";
    }
}
