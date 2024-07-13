package com.benharouga.carte.jeuxdecartes.model;

import com.benharouga.carte.jeuxdecartes.enums.Couleur;
import com.benharouga.carte.jeuxdecartes.enums.Valeur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor
@NoArgsConstructor
public class RandomCartes {
    private List<Couleur> randomColors;
    private List<Valeur> randomValues;

}
