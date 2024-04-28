package tn.pfe.rhbackend.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import tn.pfe.rhbackend.model.User;
import tn.pfe.rhbackend.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;


    public User addUser(User user) {

            return userRepository.save(user);

    }
}