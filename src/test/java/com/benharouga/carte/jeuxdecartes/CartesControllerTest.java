package com.benharouga.carte.jeuxdecartes;

import com.benharouga.carte.jeuxdecartes.controller.CartesController;
import com.benharouga.carte.jeuxdecartes.enums.Couleur;
import com.benharouga.carte.jeuxdecartes.enums.Valeur;
import com.benharouga.carte.jeuxdecartes.model.Carte;
import com.benharouga.carte.jeuxdecartes.model.Hand;
import com.benharouga.carte.jeuxdecartes.model.RandomCartes;
import com.benharouga.carte.jeuxdecartes.service.CarteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CartesControllerTest {
    @InjectMocks
    private CartesController cartesController;

    @Mock
    private CarteService carteService;

    private MockMvc mockMvc;

    @Test
    void testCreerJeuDeCartes() throws Exception {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(cartesController).build();

        RandomCartes mockRandomCartes = new RandomCartes(Arrays.asList(Couleur.hearts, Couleur.spades, Couleur.clubs),
                Arrays.asList(Valeur.as, Valeur.dame, Valeur.roi));

        when(carteService.generateRandomOrders()).thenReturn(mockRandomCartes);

        mockMvc.perform(MockMvcRequestBuilders.get("/cartes/ordreAleatoire"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.randomColors").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.randomValues").isArray());
    }

    @Test
    void testTirerMain() throws Exception {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(cartesController).build();

        List<Carte> mockMain = Arrays.asList(new Carte(Couleur.hearts, Valeur.as),
                new Carte(Couleur.spades, Valeur.dame),
                new Carte(Couleur.clubs, Valeur.roi));

        when(carteService.creerJeuDeCartes()).thenReturn(mockMain);
        when(carteService.tirerMain(mockMain)).thenReturn(mockMain);

        mockMvc.perform(MockMvcRequestBuilders.get("/cartes/tirerMain"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].couleur").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].valeur").isString());
    }

    @Test
    void testTrierMain() throws Exception {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(cartesController).build();

        Hand mockHand = new Hand();
        mockHand.setCartes(Arrays.asList(new Carte(Couleur.hearts, Valeur.as),
                new Carte(Couleur.clubs, Valeur.roi),
                new Carte(Couleur.spades, Valeur.dame)));
        mockHand.setCarteAleatoire(new RandomCartes(Arrays.asList(Couleur.hearts, Couleur.spades, Couleur.clubs),
                Arrays.asList(Valeur.as, Valeur.dame, Valeur.roi)));

        List<Carte> mockSortedHand = Arrays.asList(new Carte(Couleur.hearts, Valeur.as),
                new Carte(Couleur.spades, Valeur.dame),
                new Carte(Couleur.clubs, Valeur.roi));

        when(carteService.trierMain(mockHand.getCartes(), mockHand.getCarteAleatoire())).thenReturn(mockSortedHand);

        mockMvc.perform(MockMvcRequestBuilders.post("/cartes/trierMain")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(mockHand)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].couleur").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].valeur").isString());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
