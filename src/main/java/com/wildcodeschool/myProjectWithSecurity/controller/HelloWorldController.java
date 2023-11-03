package com.wildcodeschool.myProjectWithSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Ecole;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String accueil() {
        return "Bienvenu chez Hydra, enfin je voulais dire le SHIELD :)";
    }

    @GetMapping("/avengers/assemble")
    public String avengers() {
        return "Avengers... Rassemblement !";
    }

    
    @GetMapping("/secret-bases")
    public String baseSecrete() {
        Ecole ecole = new Ecole();
        StringBuilder resultat = new StringBuilder();
        boolean debut = true;

        for (String ville : ecole.villesEcoles()) {
            if (debut) {
                resultat.append("Voici la liste des écoles WildCodeSchool : ").append(ville);
                debut = false;
            } else {
               resultat.append(", ").append(ville);
            }
        }
        resultat.append(".");
        
        return resultat.toString();
    }

}