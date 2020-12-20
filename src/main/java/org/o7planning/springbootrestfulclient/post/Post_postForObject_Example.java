package org.o7planning.springbootrestfulclient.post;

import org.o7planning.springbootrestfulclient.model.Produit;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class Post_postForObject_Example {
    static final String URL_CREATE_PRODUIT = "http://localhost:8081/BOUTIQUE/add" ;

    public static void main(String[] args) {

       int id = 63 ;

        Produit newProduit = new Produit( id ,"iphone5", 70, 72);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();

        //Data attached to the Request
        HttpEntity<Produit> requestBody = new HttpEntity<>(newProduit, headers);

        //Send request with POST method
        Produit p = restTemplate.postForObject(URL_CREATE_PRODUIT, requestBody, Produit.class);

        if (p != null) {
            System.out.println("Produit Creer: " + p.getId());
        } else {
            System.out.println("Failed");
        }

    }
}
