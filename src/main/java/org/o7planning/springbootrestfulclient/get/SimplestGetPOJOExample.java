package org.o7planning.springbootrestfulclient.get;

import org.o7planning.springbootrestfulclient.model.Produit;
import org.springframework.web.client.RestTemplate;

public class SimplestGetPOJOExample {

    static final String URL_PRODUITS = "http://localhost:8081/BOUTIQUE/produits" ;

    static final String URL_PRODUITS_XML = "http://localhost:8081/BOUTIQUE/produits.xml" ;
    static final String URL_PRODUITS_JSON = "http://localhost:8081/BOUTIQUE/produits.json" ;

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        //Send the request wih GET method and default Headers .
        Produit[] list = restTemplate.getForObject(URL_PRODUITS, Produit[].class);

        if(list !=null) {
            for (Produit p : list) {
                System.out.println("Produit: " +p.getId()+ " --> " + p.getNom()) ;
            }
        }


    }

}




