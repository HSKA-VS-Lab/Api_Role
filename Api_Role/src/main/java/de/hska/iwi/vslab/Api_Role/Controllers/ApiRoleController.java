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

    @PostMapping("/role")
    public void addRole(@RequestBody String typ, int level) {
        apiRoleService.addRole(typ, level);
    }

    @PutMapping("/role")
    public void updateRole(@RequestBody int id, String typ, int level) {
        apiRoleService.updateRole(id, typ, level);
    }

    @DeleteMapping("/role/{id}")
    public void deleteRole(@PathVariable int id){
        apiRoleService.deleteRole(id);
    }

    @DeleteMapping("/role")
    public void deleteAllRoles(){
        apiRoleService.deleteAllRoles();
    }

}
