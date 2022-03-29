package lab.exercise.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

}
