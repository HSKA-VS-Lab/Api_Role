package de.hska.iwi.vslab.Api_Role.Controllers;

import de.hska.iwi.vslab.Api_Role.ConsumingREST.Role;
import de.hska.iwi.vslab.Api_Role.Services.ApiRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ApiRoleController {

    @Autowired
    private ApiRoleService apiRoleService;
    
    @GetMapping("/role")
    public Role[] getAllRoles() {
        return apiRoleService.getAllRoles();
    }

    @GetMapping("/role/{input}")
    public Role getRole(@PathVariable String input) {
        return apiRoleService.getRole(input);
    }

    @PostMapping(path="/role", consumes="application/json")
    public void addRole(@RequestBody(required=true) Role payload) {
        apiRoleService.addRole(payload.getType(), payload.getLevel());
    }

    @PutMapping(path="/role/{id}", consumes="application/json")
    public void updateRole(@PathVariable int id, @RequestBody(required=true) Role payload) {
        apiRoleService.updateRole(payload);
    }

    @DeleteMapping("/role/{id}")
    public void deleteRole(@PathVariable Integer id){
        apiRoleService.deleteRole(id);
    }

    @DeleteMapping("/role")
    public void deleteAllRoles(){
        apiRoleService.deleteAllRoles();
    }

}
