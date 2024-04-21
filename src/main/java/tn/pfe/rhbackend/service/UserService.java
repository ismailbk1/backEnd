package tn.pfe.rhbackend.service;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import tn.pfe.rhbackend.dto.ChangePasswordRequest;
import tn.pfe.rhbackend.model.Role;
import tn.pfe.rhbackend.model.User;
import tn.pfe.rhbackend.repository.RoleRepository;
import tn.pfe.rhbackend.repository.UserRepository;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public User fetchUser(String email) {
        return userRepository.existsByEmail(email)
                ? userRepository.findByEmail(email).get()
                : null;
    }

    public static String applicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

    @PostConstruct
    public void initRoles() {
        if (!roleRepository.existsByName("admin")) {
            Role roleAdmin = new Role();
            roleAdmin.setName("admin");
            Role role = roleRepository.save(roleAdmin);

        }
        if (!roleRepository.existsByName("agentRh")) {
            Role roleAdmin = new Role();
            roleAdmin.setName("agentRh");
            Role role = roleRepository.save(roleAdmin);
        }
        if (!roleRepository.existsByName("responsable")) {
            Role roleAdmin = new Role();
            roleAdmin.setName("responsable");
            Role role = roleRepository.save(roleAdmin);
        }
    }


}