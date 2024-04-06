package com.example.kanbansystem.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "utilisateur")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private boolean active;
    private String roles;
    @OneToMany(
            cascade=CascadeType.ALL,
            mappedBy = "user",
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private List<Board> boards;
    @ManyToMany(
            mappedBy = "users",
            fetch = FetchType.LAZY
    )
    private List<Task> tasks ;

    public User(String username, String password, String email, boolean active, String roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.active = active;
        this.roles = roles;
    }
}
