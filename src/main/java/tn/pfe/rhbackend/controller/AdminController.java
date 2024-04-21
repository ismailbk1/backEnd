package tn.pfe.rhbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tn.pfe.rhbackend.service.AdminService;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/agentRh")
    public ResponseEntity<String> createAgentAccount(@RequestParam String username, @RequestParam String password) {
        adminService.createAgentAccount(username, password);
        return ResponseEntity.ok("Agent account created successfully.");
    }

    @PostMapping("/responsable")
    public ResponseEntity<String> createManagerAccount(@RequestParam String username, @RequestParam String password) {
        adminService.createManagerAccount(username, password);
        return ResponseEntity.ok("Manager account created successfully.");
    }

}

