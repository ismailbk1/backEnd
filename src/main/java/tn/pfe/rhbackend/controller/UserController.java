package tn.pfe.rhbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pfe.rhbackend.dto.ChangePasswordResetRequest;
import tn.pfe.rhbackend.model.Besoin;
import tn.pfe.rhbackend.model.User;
import tn.pfe.rhbackend.repository.UserRepository;
import tn.pfe.rhbackend.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
@Autowired
    UserRepository userRepository;
@Autowired
    UserService userService;
  @PostMapping("/postUser")
  public User addBesoin(@RequestBody User user) {
      return userService.addUser(user);
  }
@GetMapping("/getUser")
    public List<User> getUser(){
      return userRepository.findAll();
}

    @GetMapping("/findUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userData) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setFullname(userData.getFullname());
            user.setEmail(userData.getEmail());
            user.setPassword(userData.getPassword());
            user.setRole(userData.getRole());

            User updatedUser = userRepository.save(user);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }













}