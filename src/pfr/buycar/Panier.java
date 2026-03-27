package pfr.buycar;

import java.util.ArrayList;
import java.util.List;

import pfr.buycar.utils.Icons;

public class Panier {

	private final List<String> panier = new ArrayList<>();

	public void ajouterArticle(String nomVoiture) {
		panier.add(nomVoiture);
		System.out.println("\n" + Icons.PANIER + " " + nomVoiture + " ajouté au panier !");
	}

	public void afficherPanier() {
		if (panier.isEmpty()) {
			System.out.println("\n" + Icons.ATTENTION + " Le panier est vide.");
			return;
		}

		System.out.println("\n" + Icons.PANIER + " Contenu du panier :");
		for (int i = 0; i < panier.size(); i++) {
			System.out.println((i + 1) + ". " + panier.get(i));
		}
	}

	public void viderPanier() {
		panier.clear();
		System.out.println("\n🗑️ Panier vidé !");
	}

	public boolean estVide() {
		return panier.isEmpty();
	}

	public List<String> getArticles() {
		return new ArrayList<>(panier);
	}
}
