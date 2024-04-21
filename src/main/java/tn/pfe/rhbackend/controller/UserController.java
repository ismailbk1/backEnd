package tn.pfe.rhbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pfe.rhbackend.dto.ChangePasswordResetRequest;
import tn.pfe.rhbackend.model.User;
import tn.pfe.rhbackend.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;













}