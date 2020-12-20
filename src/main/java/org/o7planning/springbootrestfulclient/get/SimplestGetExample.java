package org.o7planning.springbootrestfulclient.get;

import org.springframework.web.client.RestTemplate;

public class SimplestGetExample {

    static final String URL_PRODUITS = "http://localhost:8081/BOUTIQUE/produits" ;

    static final String URL_PRODUITS_XML = "http://localhost:8081/BOUTIQUE/produits.xml" ;
    static final String URL_PRODUITS_JSON = "http://localhost:8081/BOUTIQUE/produits.json" ;

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method and default Headers.
        String result = restTemplate.getForObject(URL_PRODUITS, String.class);

        System.out.println(result);
    }

}
