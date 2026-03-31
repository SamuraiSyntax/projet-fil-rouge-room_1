package pfr.buycar.utils;


/**
 * Interface représentant un comportement de paiement dans le projet BuyCar.
 * Les classes qui implémentent cette interface doivent définir leur logique de paiement.
 */
public interface IPayable {

    /**
     * Effectue le paiement de l'objet concerné .
     *
     * @return true si le paiement est réussi, false sinon
     */
    boolean effectuerPaiement();
}
