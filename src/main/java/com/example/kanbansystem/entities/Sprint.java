package com.example.kanbansystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Date startDate;
    private Date endDate;

    @ManyToMany(
            mappedBy = "sprints",
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private List<Task> tasks;

}
