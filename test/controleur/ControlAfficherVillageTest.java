package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	Village village;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}
	
	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
		
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		//assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
		assertNotNull(controlAfficherVillage.donnerNomsVillageois(),"Constructeur ne renvoie pas null");
		Gaulois asterix = new Gaulois("ASterix", 5);
		village.ajouterHabitant(asterix);
		assertNotNull(controlAfficherVillage.donnerNomsVillageois(), "Constructeur ne renvoie pas null");
		Druide panoramix = new Druide("Panoramix", 6, 4, 8);
		village.ajouterHabitant(panoramix);
		assertNotNull(controlAfficherVillage.donnerNomsVillageois(), "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		//assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
		assertNotNull(controlAfficherVillage.donnerNomVillage(), "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage.donnerNbEtals(), "Constructeur ne renvoie pas null");
	}

}
