package tn.pfe.rhbackend.model;

import jakarta.persistence.*;
import lombok.*;


import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="appuser")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullname;
    private String email;
    private String password;




    @ManyToOne()
    private Role role;
















}
