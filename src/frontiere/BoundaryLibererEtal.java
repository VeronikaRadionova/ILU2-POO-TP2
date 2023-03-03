package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (controlLibererEtal.isVendeur(nomVendeur) != null) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché ajourd'hui !");
		} else {
			String[] donnesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if (donnesEtal[0] == "true") { //???????
				
			}
		}
	}

}
