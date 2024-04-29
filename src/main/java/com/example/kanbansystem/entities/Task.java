package com.example.kanbansystem.entities;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"users", "sprints"})

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    private Integer estimation;
    @ManyToOne
    private Board board;
    @ManyToMany
    private List<User> users;
    @ManyToMany
    private List<Sprint> sprints;

}
