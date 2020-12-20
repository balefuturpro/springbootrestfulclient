package org.o7planning.springbootrestfulclient.puttt;

import java.util.HashMap;
import java.util.Map;

//import org.arpit.java2blog.bean.Country;
import org.o7planning.springbootrestfulclient.model.Produit;
import org.springframework.web.client.RestTemplate;
/**
 * @author Arpit Mandliya
 */
public class SpringRestTemplateExample {

    public static void main(String args[]) {

        final String uriForPut = "http://localhost:8081/BOUTIQUE/update/61";

        Produit produit = new Produit();
        produit.setId(61);
        produit.setNom("Bhutan");
        produit.setPrix(10);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put ( uriForPut, produit);
    }
}
