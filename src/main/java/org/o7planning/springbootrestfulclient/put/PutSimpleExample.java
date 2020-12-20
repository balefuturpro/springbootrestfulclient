package org.o7planning.springbootrestfulclient.put;


import org.o7planning.springbootrestfulclient.model.Produit;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class PutSimpleExample {


    public static void main(String[] args) {



        final String uriForDelete = "http://localhost:8081/BOUTIQUE/update/58";

         Produit produit = new Produit() ;
      //   produit.setId(58);
         produit.setNom("ope");
         produit.setPrix(20);
         produit.setQuantite(10);

         RestTemplate restTemplate = new RestTemplate() ;
         restTemplate.put(uriForDelete, produit);



    }

}