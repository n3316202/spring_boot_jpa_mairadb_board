package edu.mariadb.ex.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Authorities{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String authority;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Users user;
}
