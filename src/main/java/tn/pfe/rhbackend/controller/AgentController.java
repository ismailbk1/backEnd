package tn.pfe.rhbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.pfe.rhbackend.dto.AgentDto;
import tn.pfe.rhbackend.model.Agent;
import tn.pfe.rhbackend.service.AgentService;

import java.util.List;
import java.util.Optional;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")

//@PreAuthorize("hasRole('admin')")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @GetMapping("/getAgents")
    public List<Agent> getAllAgents() {

        return agentService.getAllAgents();

    }

    @GetMapping("/getAgentById/{id_agent}")
    public Optional<Agent> getAgentById(@PathVariable Long id_agent) {
        return agentService.getAgentByMatricule(id_agent);
    }

    @PostMapping("/addAgent")
    public Agent addAgent(@RequestBody AgentDto agent) {
        System.out.println(agent);

        return agentService.addAgent(agent);
    }

    @PutMapping("/updateAgent/{id_agent}")
    public Agent updateAgent(@PathVariable Integer id_agent, @RequestBody Agent agent) {
        return agentService.updateAgent(id_agent, agent);
    }

    @DeleteMapping("/deleteAgent/{id_agent}")
    public void deleteAgent(@PathVariable Integer id_agent) {
        agentService.deleteAgent(id_agent);
    }
}
