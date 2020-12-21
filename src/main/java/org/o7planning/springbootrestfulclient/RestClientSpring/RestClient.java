package org.o7planning.springbootrestfulclient.RestClientSpring;

import org.o7planning.springbootrestfulclient.model.Produit;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class RestClient {

    // declaraton des url
    private static final String GET_ALL_PRODUCT_API = "http://localhost:8081/BOUTIQUE/produits" ;
    private static final String GET_PRODUCT_BY_ID_API = "http://localhost:8081/BOUTIQUE/produits/{id}" ;
    private static final String DELETE_PRODUCT_API = "http://localhost:8081/BOUTIQUE/delete/{id}" ;
    private static final String CREATE_PRODUCT_API = "http://localhost:8081/BOUTIQUE/add" ;

    // creation de l'objet Template
   static RestTemplate restTemplate = new RestTemplate();
  static Produit produit = new Produit();

    // la fonction main

    public static void main(String[] args) {

        // mettre ici les methodes

        callGetAllProduct();

        callGetProdutiByIdAPI () ;

      //  callDeleteProductByIdent () ;

        callCreateProduct () ;
    }

    // ceration des methodes :
    // la methode d'obtention de tous les produits

    private static void callGetAllProduct () {

        Produit[] list = restTemplate.getForObject(GET_ALL_PRODUCT_API, Produit[].class) ;
        System.out.println("---------------liste des produits-----------------") ;
        if(list !=null) {
            for (Produit p : list) {
                System.out.println("Produit: " +p.getId()+ " --> " + p.getNom()) ;
            }
        }


    }

    // la methode d'obtention des produits par ID

    private static void callGetProdutiByIdAPI () {

        Map<String,Integer> param = new HashMap<>();
        param.put("id" , 59) ;

        Produit produit = restTemplate.getForObject(GET_PRODUCT_BY_ID_API, Produit.class, param) ;
        System.out.println("---------------liste des produits par ID-----------------") ;
        System.out.println(produit.getNom());
        System.out.println(produit.getPrix());
        System.out.println(produit.getQuantite());

    }

    private static void callDeleteProductByIdent () {

        Map<String, String> params = new HashMap<String, String>();
        params.put("id","58");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete ( DELETE_PRODUCT_API,params);


        System.out.println("(Client side) Produit after delete: ");
        System.out.println("Produit: " + produit.getId() + " - " + produit.getNom()
                + "-" + produit.getPrix()  + "-" + produit.getQuantite());
        System.out.println("Product delete Successfuly") ;

    }

    private static void callCreateProduct () {

        int id = 64 ;

        Produit newProduit = new Produit( id ,"mo", 70, 72);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Data attached to the Request
        HttpEntity<Produit> requestBody = new HttpEntity<>(newProduit, headers);

        //Send request with POST method
        Produit p = restTemplate.postForObject(CREATE_PRODUCT_API, requestBody, Produit.class);

        if (p != null) {
            System.out.println("Produit Creer: " + p.getId());
        } else {
            System.out.println("Failed");
        }

    }


}
