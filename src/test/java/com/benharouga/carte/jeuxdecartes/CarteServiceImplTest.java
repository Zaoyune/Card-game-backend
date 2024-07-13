package com.benharouga.carte.jeuxdecartes;

import com.benharouga.carte.jeuxdecartes.enums.Couleur;
import com.benharouga.carte.jeuxdecartes.enums.Valeur;
import com.benharouga.carte.jeuxdecartes.model.Carte;
import com.benharouga.carte.jeuxdecartes.model.RandomCartes;
import com.benharouga.carte.jeuxdecartes.service.CarteServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

public class CarteServiceImplTest {
    @InjectMocks
    private CarteServiceImpl carteService;

    @Mock
    private RandomCartes mockRandomCartes;

    @Test
    void testGenerateRandomOrders() {
        CarteServiceImpl carteService = new CarteServiceImpl();

        RandomCartes result1 = carteService.generateRandomOrders();
        RandomCartes result2 = carteService.generateRandomOrders();

        assertNotEquals(result1, result2);
    }


    @Test
    void testCreerJeuDeCartes() {
        List<Carte> jeuDeCartes = carteService.creerJeuDeCartes();

        assertEquals(Couleur.values().length * Valeur.values().length, jeuDeCartes.size());
    }

    @Test
    void testTirerMain() {
        List<Carte> jeuDeCartes = Arrays.asList(new Carte(Couleur.hearts, Valeur.as),
                new Carte(Couleur.diamonds, Valeur.neuf),
                new Carte(Couleur.spades, Valeur.valet),
                new Carte(Couleur.hearts, Valeur.deux),
                new Carte(Couleur.diamonds, Valeur.roi),
                new Carte(Couleur.spades, Valeur.cinq),
                new Carte(Couleur.diamonds, Valeur.dame),
                new Carte(Couleur.clubs, Valeur.sept),
                new Carte(Couleur.diamonds, Valeur.dix),
                new Carte(Couleur.clubs, Valeur.roi));
        List<Carte> main = carteService.tirerMain(jeuDeCartes);
        assertEquals(10, main.size());
    }

    @Test
    void testTrierMain() {
        List<Carte> main = Arrays.asList(new Carte(Couleur.hearts, Valeur.as),
                new Carte(Couleur.diamonds, Valeur.neuf),
                new Carte(Couleur.spades, Valeur.valet),
                new Carte(Couleur.hearts, Valeur.deux),
                new Carte(Couleur.diamonds, Valeur.roi),
                new Carte(Couleur.spades, Valeur.cinq),
                new Carte(Couleur.diamonds, Valeur.dame),
                new Carte(Couleur.clubs, Valeur.sept),
                new Carte(Couleur.diamonds, Valeur.dix),
                new Carte(Couleur.clubs, Valeur.roi));

        when(mockRandomCartes.getRandomColors()).thenReturn(Arrays.asList(Couleur.hearts, Couleur.spades, Couleur.clubs,Couleur.diamonds));
        when(mockRandomCartes.getRandomValues()).thenReturn(Arrays.asList(Valeur.roi, Valeur.dame,  Valeur.valet,Valeur.dix, Valeur.neuf,
                Valeur.huit, Valeur.sept, Valeur.six, Valeur.cinq, Valeur.quatre, Valeur.trois, Valeur.deux, Valeur.as));

        List<Carte> sortedMain = carteService.trierMain(main, mockRandomCartes);

        assertEquals(new Carte(Couleur.hearts, Valeur.deux), sortedMain.get(0));
        assertEquals(new Carte(Couleur.hearts, Valeur.as), sortedMain.get(1));
        assertEquals(new Carte(Couleur.spades, Valeur.valet), sortedMain.get(2));
        assertEquals(new Carte(Couleur.spades, Valeur.cinq), sortedMain.get(3));
        assertEquals(new Carte(Couleur.clubs, Valeur.roi), sortedMain.get(4));
        assertEquals(new Carte(Couleur.clubs, Valeur.sept), sortedMain.get(5));
        assertEquals(new Carte(Couleur.diamonds, Valeur.roi), sortedMain.get(6));
        assertEquals(new Carte(Couleur.diamonds, Valeur.dame), sortedMain.get(7));
        assertEquals(new Carte(Couleur.diamonds, Valeur.dix), sortedMain.get(8));
        assertEquals(new Carte(Couleur.diamonds, Valeur.neuf), sortedMain.get(9));
    }


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}
