package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolée, " + nomAcheteur + " mais il faut être un habitant de notre village pour commencer ici.");
		} else {
			String produit = Clavier.entrerString("Quel produit voulez-vous acheter ?");
			Gaulois[] etalsProduit = controlAcheterProduit.chercherProduit(produit);
			if (etalsProduit == null) {
				System.out.println("Désolée, personne ne vend ce produit au marché.");
			} else {
				int nbCommercants = etalsProduit.length;
				
				StringBuilder question = new StringBuilder();
				question.append("Chez quel commerçant voulez-vous acheter des " + produit + "\n");
				for (int i=0; i<nbCommercants; i++) {
					question.append(String.valueOf(i+1) + " - " + etalsProduit[i].getNom() + "\n");
				}
				
				int choixUtilisateur = -1;
				String nomCommercant = "nom";
				
				while ((choixUtilisateur < 0) || (choixUtilisateur > nbCommercants)) {
					choixUtilisateur = Clavier.entrerEntier(question.toString());
					if ((choixUtilisateur < 0) || (choixUtilisateur > nbCommercants)) {
						System.out.println("Vous devez choisir le chiffre entre 1 et " + String.valueOf(nbCommercants) + " !");
					}
				}
				
				if ((choixUtilisateur > 0 ) && (choixUtilisateur < nbCommercants)) {
					for (int i=0; i<nbCommercants; i++) {
						if (choixUtilisateur == i) {
							nomCommercant = etalsProduit[i-1].getNom();
						}
					}
				} 
				if (choixUtilisateur == nbCommercants) {
					nomCommercant = etalsProduit[nbCommercants-1].getNom();
				}
				
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomCommercant + "\n");
				
				int nbProduit = Clavier.entrerEntier("Bonjour, " + nomAcheteur + "\nCombien de " + produit + " voulez-vous acheter ?");
				Etal etalCommercant = controlAcheterProduit.trouverEtalProduit(nomCommercant);
				int quantite = Integer.valueOf(etalCommercant.getQuantite());
				
				if (quantite == 0) {
					System.out.println(nomAcheteur + " veut acheter " + nbProduit + " " + produit + ", malheureusement il n’y en a plus !");
				} else {
					
					if (nbProduit > quantite) {
						System.out.println(nomAcheteur + " veut acheter " + nbProduit + " " + produit + ", malheureusement " + nomCommercant + " n’en a plus que " + quantite + ". " + nomAcheteur + " achète tout le stock de " + nomCommercant + ".");
					} else {
						System.out.println(nomAcheteur + " achète " + nbProduit + " fleurs à " + nomCommercant + ".");
					}
					etalCommercant.acheterProduit(nbProduit);
				}
			}
		}
	}
}
