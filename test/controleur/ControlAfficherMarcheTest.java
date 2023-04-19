package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	Village village;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 2);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlAfficherMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		assertNotNull(controlAfficherMarche, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerInfosMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		//String[] donnes = new String[0];
		assertNotNull(controlAfficherMarche.donnerInfosMarche());
		assertEquals(controlAfficherMarche.donnerInfosMarche().length, 0, "Le marché est vide mais le constructeur n'est pas null");
		Gaulois asterix = new Gaulois("Asterix",5);
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "fleurs", 4);
		assertNotNull(controlAfficherMarche.donnerInfosMarche(), "Les infos du marché existent");
	}

}
