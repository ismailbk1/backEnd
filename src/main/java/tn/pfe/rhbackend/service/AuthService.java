package tn.pfe.rhbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.pfe.rhbackend.dto.LoginDto;
import tn.pfe.rhbackend.dto.UserDto;
import tn.pfe.rhbackend.model.User;
import tn.pfe.rhbackend.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public ResponseEntity<?> login(LoginDto loginDto) {
        Optional<User> optionalUser=userRepository.findByEmail(loginDto.getEmail());
        if(optionalUser.isPresent()){
            User user=optionalUser.get();
            if(user.getPassword().equals(loginDto.getPassword())){
                UserDto userDto=new UserDto();
                userDto.setFullname(user.getFullname());
                userDto.setRole(user.getRole());
                userDto.setEmail(user.getEmail());
                return ResponseEntity.ok(userDto);
            }
            else {
                return new ResponseEntity<>("Please Check Your Password",HttpStatus.BAD_REQUEST);

            }



        }else {
            return new ResponseEntity<>("USer Not Found With This Email",HttpStatus.NOT_FOUND);
        }
    }


}
