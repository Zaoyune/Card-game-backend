package com.benharouga.carte.jeuxdecartes.controller;

import com.benharouga.carte.jeuxdecartes.model.Carte;
import com.benharouga.carte.jeuxdecartes.model.Hand;
import com.benharouga.carte.jeuxdecartes.model.RandomCartes;
import com.benharouga.carte.jeuxdecartes.service.CarteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cartes")
public class CartesController {

    private CarteService carteService;

    public CartesController(CarteService carteService) {
        this.carteService = carteService;
    }

    @GetMapping("/ordreAleatoire")
    public RandomCartes creerJeuDeCartes() {
        return carteService.generateRandomOrders();
    }

    @GetMapping("/tirerMain")
    public List<Carte> tirerMain() {
        List<Carte> jeuDeCartes = carteService.creerJeuDeCartes();
        return carteService.tirerMain(jeuDeCartes);
    }

    @PostMapping("/trierMain")
    public List<Carte> trierMain(@RequestBody Hand hand) {
        return carteService.trierMain(hand.getCartes(), hand.getCarteAleatoire());
    }


}
