package com.benharouga.carte.jeuxdecartes.service;

import com.benharouga.carte.jeuxdecartes.enums.Couleur;
import com.benharouga.carte.jeuxdecartes.enums.Valeur;
import com.benharouga.carte.jeuxdecartes.model.Carte;
import com.benharouga.carte.jeuxdecartes.model.RandomCartes;

import java.util.List;

/**
 * Service pour la gestion des opérations liées aux cartes.
 */
public interface CarteService {
    /**
     * Génère des ordres aléatoires pour les couleurs et les valeurs.
     *
     * @return Ordres aléatoires pour les couleurs et les valeurs.
     */
    RandomCartes generateRandomOrders();

    /**
     * Crée un jeu complet de cartes.
     *
     * @return Une liste représentant un jeu complet de cartes.
     */
    List<Carte> creerJeuDeCartes();

    /**
     * Tire une main de cartes de manière aléatoire depuis le jeu.
     *
     * @param jeuDeCartes Le jeu de cartes duquel tirer la main.
     * @return Une main de dix cartes.
     */
    List<Carte> tirerMain(List<Carte> jeuDeCartes);

    /**
     * Trie une main de cartes par couleur et valeur selon des ordres aléatoires.
     *
     * @param main           La main de cartes à trier.
     * @param ordresAleatoires Ordres aléatoires pour les couleurs et les valeurs.
     * @return La main de cartes triée.
     */
    List<Carte> trierMain(List<Carte> main, RandomCartes ordresAleatoires);

}
