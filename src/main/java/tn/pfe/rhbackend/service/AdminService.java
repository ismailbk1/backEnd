package tn.pfe.rhbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import tn.pfe.rhbackend.model.Role;
import tn.pfe.rhbackend.model.User;
import tn.pfe.rhbackend.repository.RoleRepository;
import tn.pfe.rhbackend.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
  //  private final PasswordEncoder passwordEncoder;



    public void createAgentAccount(String username, String password) {
        createUserAccount(username, password, "agentRh");
    }

    public void createManagerAccount(String username, String password) {
        createUserAccount(username, password, "responsable");
    }

    private void createUserAccount(String email, String password, String roleName) {
        Role role = roleRepository.findByName(roleName).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        if (role == null) {
            throw new IllegalStateException("Role " + roleName + " not found.");
        }

      /*  // Méthode pour récupérer tous les utilisateurs par rôle
        public List<User> getAllUsersByRole(String roleName) {
            Role role = roleRepository.findByName(roleName)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            return userRepository.findByRole(role);
        }*/

        User user = new User();
        user.setEmail(email);
      //  user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);


        userRepository.save(user);
    }
}

