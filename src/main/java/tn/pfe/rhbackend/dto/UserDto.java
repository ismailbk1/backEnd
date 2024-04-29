package tn.pfe.rhbackend.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import tn.pfe.rhbackend.model.Role;

@Data
public class UserDto {
    private String fullname;
    private String email;
    private Role role;
}
