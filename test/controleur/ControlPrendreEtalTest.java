package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 2);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix",5);
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "fleurs", 4);
		
	}

	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal,"Constructeur ne renvoie pas null");
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.resteEtals(), "Il y a des étals disponibles");
		Gaulois obelix = new Gaulois("Obelix", 10);
		village.ajouterHabitant(obelix);
		village.installerVendeur(obelix, "fleurs", 3);
		assertFalse(controlPrendreEtal.resteEtals(), "Il n'y pas d'étals disponibles");
		
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertEquals(controlPrendreEtal.prendreEtal("Obelix", "fleurs", 6), -1, "Le gaulois n'appartient pas à ce village et ne peut pas occuper l'étal");
		Gaulois obelix = new Gaulois("Obelix", 10);
		village.ajouterHabitant(obelix);
		assertEquals(controlPrendreEtal.prendreEtal("Asterix", "fleurs", 5),1, "Numéro saisi est le même que le numéro d'étal occupé");
		assertNotEquals(controlPrendreEtal.prendreEtal("Obelix", "fleurs", 6),1, "Numéro saisi ne correspond pas au numéro d'étal occupé");
	}

	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		//assertNotNull(controlPrendreEtal,"Constructeur ne renvoie pas null");
		assertTrue(controlPrendreEtal.verifierIdentite("Asterix"), "Ce gaulois habite dans ce village");
		assertFalse(controlPrendreEtal.verifierIdentite("Obelix"), "Ce gaulois n'habite pas dans ce village");
	}

}
