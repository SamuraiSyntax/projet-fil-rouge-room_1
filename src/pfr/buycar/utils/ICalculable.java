package pfr.buycar.utils;


/**
 * Interface représentant une entité capable de calculer un total (prix, montant, etc.).
 */
public interface ICalculable {

    /**
     * Calcule le total associé à l'objet implémentant cette interface.
     *
     * @return le total sous forme de float
     */
    float calculerTotal();
}
