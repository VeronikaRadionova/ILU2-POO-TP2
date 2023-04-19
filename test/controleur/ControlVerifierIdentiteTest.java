package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	Village village;
	
	@BeforeEach
	public void initiliserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix",5);
		village.ajouterHabitant(asterix);
	}

	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite, "Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertTrue(controlVerifierIdentite.verifierIdentite("Asterix"), "Ce gaulois habite dans ce village");
		assertFalse(controlVerifierIdentite.verifierIdentite("Obelix"), "Ce gaulois n(habite pas dans ce village");
		//assertTrue(controlVerifierIdentite.verifierIdentite("Abraracourcix"));
	}

}
