package de.hska.iwi.vslab.Api_Role.ConsumingREST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class ConsumeCoreRole {
    
    // private String urlCoreProduct = "http://localhost:8084/role";

    private static final Logger log = LoggerFactory.getLogger(ConsumeCoreRole.class);
    RestTemplate restTemplate = new RestTemplate();

    public Role[] getAllRoles() {
        try {
            UrlBuilder urlBuilder = new UrlBuilder();
            log.info("URL:" + urlBuilder.getBaseUrl());
            return restTemplate.getForObject(urlBuilder.getBaseUrl(), Role[].class);
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public Role getRole(String input) {
        try {
            UrlBuilder urlBuilder = new UrlBuilder();
            log.info("URL:" + urlBuilder.getBaseUrl());
        return restTemplate.getForObject(urlBuilder.getInputUrl(input), Role.class);
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public void addRole(Role role) {
        try {
            UrlBuilder urlBuilder = new UrlBuilder();
            log.info("URL:" + urlBuilder.getBaseUrl());
            HttpEntity<Role> request = new HttpEntity<>(new Role(role.getType(), role.getLevel()));
            restTemplate.postForLocation(urlBuilder.getBaseUrl(), request);
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public void updateRole(Role role) {
        try {
            UrlBuilder urlBuilder = new UrlBuilder();
            log.info("URL:" + urlBuilder.getUrlWithId(role.getId()));
            // HttpEntity<Role> request = new HttpEntity<>(new Role(role.getId(), role.getType(), role.getLevel()));
            restTemplate.put(urlBuilder.getUrlWithId(role.getId()), role);
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public void deleteRole(int id){
        try {
            UrlBuilder urlBuilder = new UrlBuilder();
            log.info("delete URL to core_role:" + urlBuilder.getUrlWithId(id), id);
            restTemplate.delete(urlBuilder.getUrlWithId(id), id);
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public void deleteAllRoles(){
        try {
            UrlBuilder urlBuilder = new UrlBuilder();
            log.info("URL:" + urlBuilder.getBaseUrl());
            restTemplate.delete(urlBuilder.getBaseUrl());
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

}