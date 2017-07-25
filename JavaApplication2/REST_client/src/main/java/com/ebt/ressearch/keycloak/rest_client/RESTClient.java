/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebt.ressearch.keycloak.rest_client;

import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:MyRest [hello]<br>
 * USAGE:
 * <pre>
 *        RESTClient client = new RESTClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author vasil
 */
public class RESTClient {

    private javax.ws.rs.client.WebTarget webTarget;
    private javax.ws.rs.client.Client client;
    private static final String BASE_URI = "http://192.168.1.150:8080/testRest/webresources";

    public RESTClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("hello");
    }

    public <T> T getText(Class<T> responseType, String id) throws javax.ws.rs.ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String setUser(Object requestEntity) throws javax.ws.rs.ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), String.class);
    }

    public void close() {
        client.close();
    }

    void getText(Class<String> aClass, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
