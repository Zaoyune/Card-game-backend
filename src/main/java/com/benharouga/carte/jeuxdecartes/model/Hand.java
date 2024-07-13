package com.benharouga.carte.jeuxdecartes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hand {
        private List<Carte> cartes;
        private RandomCartes carteAleatoire;


}
