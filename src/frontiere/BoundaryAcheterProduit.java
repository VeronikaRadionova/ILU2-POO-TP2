package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

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
			if (!controlAcheterProduit.chercherProduit(produit)) {
				System.out.println("Désolée, personne ne vend ce produit au marché.");
			} else {
				String nomCommercant = Clavier.entrerString("Chez quel commerçant voulez-vous acheter des fleurs ?");
				// tut pohoje nado sdelat' vybor kak v Emmenager i drugih pohojih shtukah
				// so string builderom i cyclom vyvodiashim imena gallov; vozmogno do etogo ih nado v tablizu vsio taki zapisat'
			}
		}
	}
}
