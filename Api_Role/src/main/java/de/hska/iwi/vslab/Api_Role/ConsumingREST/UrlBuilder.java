package de.hska.iwi.vslab.Api_Role.ConsumingREST;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;


public class UrlBuilder {

    private String baseUrl;

    public UrlBuilder(){
        LoadBalancerClient loadBalancer = BeanUtil.getBean(LoadBalancerClient.class);
        ServiceInstance si = loadBalancer.choose("core_role");
        this.baseUrl =  si.getUri().toString();
    }


    String getBaseUrl(){
        return baseUrl + "/role";
    }

    String getSlashURL(){
        return baseUrl+"/";
    }

    String getUrlWithId(int id){
        return baseUrl+"/"+id;
    }

    String getInputUrl(String input){
        return getBaseUrl() + "/" + input;
    }

}