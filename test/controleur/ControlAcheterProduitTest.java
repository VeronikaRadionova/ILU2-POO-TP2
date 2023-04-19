package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	Village village;
	ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 2);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix",5);
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "fleurs", 4);
	}

	@Test
	void testControlAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, 
				controlTrouverEtalVendeur, village);
		assertNotNull(controlAcheterProduit, "Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, 
				controlTrouverEtalVendeur, village);
		//assertNotNull(controlPrendreEtal,"Constructeur ne renvoie pas null");
		assertTrue(controlAcheterProduit.verifierIdentite("Asterix"));
		assertFalse(controlAcheterProduit.verifierIdentite("Obelix"));
	}

	@Test
	void testChercherProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, 
				controlTrouverEtalVendeur, village);
		assertNotNull(controlAcheterProduit.chercherProduit("fleurs"));
		assertNull(controlAcheterProduit.chercherProduit("poissons"));
	}

	@Test
	void testTrouverEtalProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, 
				controlTrouverEtalVendeur, village);
		assertNotNull(controlAcheterProduit.trouverEtalProduit("Asterix"));
		assertNull(controlAcheterProduit.trouverEtalProduit("Obelix"));
	}

}
