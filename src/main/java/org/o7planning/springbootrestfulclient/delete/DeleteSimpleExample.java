package org.o7planning.springbootrestfulclient.delete;

import org.o7planning.springbootrestfulclient.model.Produit;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class DeleteSimpleExample {

    public static void main(String[] args) {

            Produit produit = new Produit() ;

            final String uriForDelete = "http://localhost:8081/BOUTIQUE/delete/62";

            Map<String, String> params = new HashMap<String, String>();
           params.put("id","62");

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.delete ( uriForDelete,params);


            System.out.println("(Client side) Produit after delete: ");
            System.out.println("Produit: " + produit.getId() + " - " + produit.getNom()
                    + "-" + produit.getPrix()  + "-" + produit.getQuantite());
            System.out.println("Product delete Successfuly") ;

       //     System.out.println("Produit not found!");

    }
}
