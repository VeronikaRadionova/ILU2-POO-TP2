package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

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
			Gaulois[] vendeurAvecProduit = controlAcheterProduit.chercherProduit(produit);
			if (vendeurAvecProduit == null) {
				System.out.println("Désolée, personne ne vend ce produit au marché.");
			} else {
				
				// tut pohoje nado sdelat' vybor kak v Emmenager i drugih pohojih shtukah
				// so string builderom i cyclom vyvodiashim imena gallov; vozmogno do etogo ih nado v tablizu vsio taki zapisat'
				//poluchit' nujno imia prodavca
				
				int nbProduit = Clavier.entrerEntier("Bonjour, " + nomAcheteur + "\n Combien de " + produit + " voulez-vous acheter ?");
				String[] etalCommercant = controlAcheterProduit.trouverEtalProduit(nomCommercant);
				int quantite = Integer.valueOf(etalCommercant[3]);
				
				if (quantite == 0) {
					System.out.println(nomAcheteur + " veut acheter " + nbProduit + " " + produit + ", malheureusement il n’y en a plus !");
				} else {
					
					if (nbProduit > quantite) {
						System.out.println(nomAcheteur + " veut acheter " + nbProduit + " " + produit + ", malheureusement " + nomCommercant + " n’en a plus que " + quantite + ". Panoramix achète tout le stock de Bonemine.");
						etalCommercant[4] = String.valueOf(0);
					} else {
						System.out.println(nomAcheteur + " achète 5 fleurs à " + nomCommercant + ".");
						etalCommercant[4] = String.valueOf(quantite - nbProduit);
					}
				}
			}
		}
	}
}
