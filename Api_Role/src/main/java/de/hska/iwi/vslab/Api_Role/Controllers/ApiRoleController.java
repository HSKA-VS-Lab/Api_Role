package de.hska.iwi.vslab.Api_Role.Controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import de.hska.iwi.vslab.Api_Role.ConsumingREST.Role;
import de.hska.iwi.vslab.Api_Role.Services.ApiRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.*;


@RestController
@EnableCircuitBreaker
public class ApiRoleController {

    @Autowired
    private ApiRoleService apiRoleService;
    
    @GetMapping("/role")
    @HystrixCommand(fallbackMethod = "fallbackGetRoles")
    public Role[] getAllRoles() {
        return apiRoleService.getAllRoles();
    }

    public Role[] fallbackGetRoles() {
        Role role1 = new Role("adminFallback",0);
        Role role2 = new Role("userFallback",1);
        Role[] roleA = new Role[2];
        roleA[0] = role1;
        roleA[1] = role2;
        return roleA;
    }

    @GetMapping("/role/{input}")
    //@HystrixCommand(fallbackMethod = "fallbackGetRole")
    public Role getRole(@PathVariable String input) {
        return apiRoleService.getRole(input);
    }

    public Role fallbackAddRole() {
        Role role = new Role("userFallback",1);
        return role;
    }

    @PostMapping(path="/role", consumes="application/json")
    //@HystrixCommand(fallbackMethod = "defaultFallback")
    public void addRole(@RequestBody(required=true) Role payload) {
        apiRoleService.addRole(payload.getType(), payload.getLevel());
    }

    @PutMapping(path="/role/{id}", consumes="application/json")
    //@HystrixCommand(fallbackMethod = "defaultFallbackWithId")
    public void updateRole(@PathVariable int id, @RequestBody(required=true) Role payload) {
        apiRoleService.updateRole(payload);
    }

    @DeleteMapping("/role/{id}")
    //@HystrixCommand(fallbackMethod = "defaultFallbackWithId")
    public void deleteRole(@PathVariable Integer id){
        apiRoleService.deleteRole(id);
    }

    @DeleteMapping("/role")
    //@HystrixCommand(fallbackMethod = "defaultFallback")
    public void deleteAllRoles(){
        apiRoleService.deleteAllRoles();
    }

    public void defaultFallback(Throwable throwable) {
        System.out.printf("DefaultFallback, exception=%s%n", throwable);
    }

    public void defaultFallbackWithId(int id, Throwable throwable) {
        System.out.printf("DefaultFallbackWithId, id=%s, exception=%s%n", id, throwable);
    }
}
