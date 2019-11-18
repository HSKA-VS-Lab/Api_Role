package de.hska.iwi.vslab.Api_Role.Services;

import org.springframework.stereotype.Service;

import de.hska.iwi.vslab.Api_Role.ConsumingREST.ConsumeCoreRole;
import de.hska.iwi.vslab.Api_Role.ConsumingREST.Role;

/**
 * The implementation of the service.
 */
@Service
public class ApiRoleService {
    
    ConsumeCoreRole coreRole = new ConsumeCoreRole();

    public Role[] getAllRoles() {
        return coreRole.getAllRoles();
    }

    public Role getRole(String input) {
        return coreRole.getRole(input);
    }

    public void addRole(String typ, int level) {
        coreRole.addRole(new Role(typ, level));
    }

    public void updateRole(int id, String typ, int level) {
        Role role = coreRole.getRole(Integer.toString(id));
        role.setLevel(level);
        role.setType(typ);
        coreRole.updateRole(role);
    }

    public void deleteRole(int id){
        coreRole.deleteRole(id);
    }

    public void deleteAllRoles(){
        coreRole.deleteAllRoles();
    }
    
}
