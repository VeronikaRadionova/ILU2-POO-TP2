package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		//verifier avec verifier identite i td
		System.out.println("Bonjour " + nomVendeur + " , je vais regarder si je peux vous trouver un étal. C'est parfait, il me reste un étal pour vous !\r\n"
				+ "Il me faudrait quelques renseignements :");
		String produit = ("Quel produit souhaitez-vous vendre ?");
		
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
