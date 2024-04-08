package com.example.kanbansystem.entities;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "users")
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
   // @JsonIgnore
    private Board board;
    @ManyToMany
  // @JsonIgnore
    private List<User> users;
}
