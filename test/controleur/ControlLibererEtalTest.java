package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	Village village;
	ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 2);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		
	}

	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal, "Constructeur ne renvoie pas null");
	}

	@Test
	void testIsVendeur() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertFalse(controlLibererEtal.isVendeur("Asterix"), "Ce vendeur n'existe pas");
		Gaulois asterix = new Gaulois("Asterix",5);
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "fleurs", 4);
		assertTrue(controlLibererEtal.isVendeur("Asterix"), "Ce vendeur existe");
	}

	@Test
	void testLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		Gaulois asterix = new Gaulois("Asterix",5);
		village.ajouterHabitant(asterix);
		assertNull(controlLibererEtal.libererEtal("Asterix"));
		village.installerVendeur(asterix, "fleurs", 4);
		assertNotNull(controlLibererEtal.libererEtal("Asterix"));
	}

}
