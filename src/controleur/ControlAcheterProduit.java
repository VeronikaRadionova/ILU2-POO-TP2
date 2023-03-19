package controleur;

import villagegaulois.Village;
import personnages.Gaulois;
import villagegaulois.Etal;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
	
	public Gaulois[] chercherProduit(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	public String[] trouverEtalProduit(String nomVendeur) { //c'est pour verifier le nombre de produit et la quantiter
		Etal etalAvecProduit = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etalAvecProduit.etatEtal();
	}
}
