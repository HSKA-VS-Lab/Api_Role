package de.hska.iwi.vslab.Api_Role.ConsumingREST;

import org.springframework.web.client.RestTemplate;

public class ConsumeCoreRole {
    
    private String urlCoreProduct = "http://localhost:8084/role";
    
    RestTemplate restTemplate = new RestTemplate();

    public Role[] getAllRoles() {
        return restTemplate.getForObject(urlCoreProduct, Role[].class);
    }

    public Role getRole(String input) {
        return restTemplate.getForObject(urlCoreProduct + "/" + input, Role.class);
    }

    public void addRole(Role role) {
        restTemplate.postForLocation(urlCoreProduct, role);
    }

    public void updateRole(Role role) {
        restTemplate.put(urlCoreProduct, role);
    }

    public void deleteRole(int id){
        restTemplate.delete(urlCoreProduct + "/" + id);
    }

    public void deleteAllRoles(){
        restTemplate.delete(urlCoreProduct);
    }

}