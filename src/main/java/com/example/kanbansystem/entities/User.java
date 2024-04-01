package com.example.kanbansystem.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "utilisateur")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    @OneToMany(
            cascade=CascadeType.ALL,
            mappedBy = "user",
            fetch = FetchType.LAZY
    )
    private List<Board> boards;
    @ManyToMany(
            mappedBy = "users",
            fetch = FetchType.LAZY
    )
    private List<Task> tasks ;
}
