package org.o7planning.springbootrestfulclient.post;

import org.o7planning.springbootrestfulclient.model.Produit;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Post_postForEntity_Example {

    static final String URL_CREATE_PRODUIT = "http://localhost:8081/BOUTIQUE/add" ;

    public static void main(String[] args) {
        Produit newProduit = new Produit(62,"iphone6",50,90);

        RestTemplate restTemplate = new RestTemplate();

        // Data attached to the request.
        HttpEntity<Produit> requestBody = new HttpEntity<>(newProduit);

        // Send request with POST method.
        ResponseEntity<Produit> result
                = restTemplate.postForEntity(URL_CREATE_PRODUIT, requestBody,
                Produit.class);
        System.out.println("Status Code:" + result.getStatusCode());

        //Code = 200.
        if(result.getStatusCode() == HttpStatus.OK) {
            Produit p = result.getBody();
            System.out.println("(Client Side) Produit Created: " + p.getId());
        }
    }
}
