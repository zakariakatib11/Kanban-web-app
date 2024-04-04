package com.example.kanbansystem.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @OneToMany(
            mappedBy = "board",
            fetch = FetchType.LAZY
    )
    private List<Task> tasks;
    @ManyToOne
    private user user;

}
