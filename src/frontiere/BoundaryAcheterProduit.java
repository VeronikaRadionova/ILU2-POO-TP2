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
				Gaulois[] etalsProduit = controlAcheterProduit.chercherProduit(produit);
				int nbCommercants = etalsProduit.length;
				
				StringBuilder question = new StringBuilder();
				question.append("Chez quel commerçant voulez-vous acheter des " + produit + "\n");
				for (int i=0; i<nbCommercants; i++) {
					question.append(String.valueOf(i+1) + " - " + etalsProduit[i].getNom() + "\n");
				}
				
				int choixUtilisateur = -1;
				String nomCommercant = "nom";
				
				// ça marche pas et JE NE COMPRENDS PAS POURQUOI !!!
				do { 
					choixUtilisateur = Clavier.entrerEntier(question.toString());
					if ((choixUtilisateur > 0 ) && (choixUtilisateur < nbCommercants)) {
						for (int i=0; i<nbCommercants; i++) {
							if (choixUtilisateur == i) {
								nomCommercant = etalsProduit[i-1].getNom();
							}
						}
					} else if (choixUtilisateur == nbCommercants) {
						nomCommercant = etalsProduit[nbCommercants-1].getNom();
					} else {
						System.out.println("Vous devez choisir le chiffre entre 1 et " + String.valueOf(nbCommercants) + " !");
						// il ne traite pas cette situation - ne continue pas boucle while...
					}	
				} while ((choixUtilisateur < 0) || (choixUtilisateur > nbCommercants));
				 
				
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomCommercant + "\n");
				
				int nbProduit = Clavier.entrerEntier("Bonjour, " + nomAcheteur + "\n Combien de " + produit + " voulez-vous acheter ?");
				String[] etalCommercant = controlAcheterProduit.trouverEtalProduit(nomCommercant);
				int quantite = Integer.valueOf(etalCommercant[3]);
				
				if (quantite == 0) {
					System.out.println(nomAcheteur + " veut acheter " + nbProduit + " " + produit + ", malheureusement il n’y en a plus !");
				} else {
					
					if (nbProduit > quantite) {
						System.out.println(nomAcheteur + " veut acheter " + nbProduit + " " + produit + ", malheureusement " + nomCommercant + " n’en a plus que " + quantite + ". Panoramix achète tout le stock de Bonemine.");
						etalCommercant[4] = String.valueOf(0); // ça ne change pas ....
					} else {
						System.out.println(nomAcheteur + " achète " + nbProduit + " fleurs à " + nomCommercant + ".");
						etalCommercant[4] = String.valueOf(quantite - nbProduit); // ou on change [3] ???
					}
				}
			}
		}
	}
}
