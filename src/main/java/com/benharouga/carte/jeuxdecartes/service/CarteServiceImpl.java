package com.benharouga.carte.jeuxdecartes.service;

import com.benharouga.carte.jeuxdecartes.enums.Couleur;
import com.benharouga.carte.jeuxdecartes.enums.Valeur;
import com.benharouga.carte.jeuxdecartes.model.Carte;
import com.benharouga.carte.jeuxdecartes.model.RandomCartes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CarteServiceImpl implements CarteService{

    @Override
    public RandomCartes generateRandomOrders() {
        List<Couleur> couleurs = Arrays.asList(Couleur.values());
        Collections.shuffle(couleurs);

        List<Valeur> valeurs = Arrays.asList(Valeur.values());
        Collections.shuffle(valeurs);

        return new RandomCartes(couleurs, valeurs);
    }

    @Override
    public List<Carte> creerJeuDeCartes() {
        List<Carte> jeuDeCartes = new ArrayList<>();
        for (Couleur couleur : Couleur.values()) {
            for (Valeur valeur : Valeur.values()) {
                jeuDeCartes.add(new Carte(couleur, valeur));
            }
        }
        return jeuDeCartes;
    }

    @Override
    public List<Carte> tirerMain(List<Carte> jeuDeCartes) {
        Collections.shuffle(jeuDeCartes);
        return jeuDeCartes.subList(0, 10);
    }

    @Override
    public List<Carte> trierMain(List<Carte> main, RandomCartes carteAleatoire) {
        main.sort((c1, c2) -> {
            int compareCouleur = carteAleatoire.getRandomColors().indexOf(c1.couleur) - carteAleatoire.getRandomColors().indexOf(c2.couleur);
            if (compareCouleur == 0) {
                return carteAleatoire.getRandomValues().indexOf(c1.valeur) - carteAleatoire.getRandomValues().indexOf(c2.valeur);
            }
            return compareCouleur;
        });
        return main;
    }
}
