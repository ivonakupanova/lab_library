package lab.exercise.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

}
