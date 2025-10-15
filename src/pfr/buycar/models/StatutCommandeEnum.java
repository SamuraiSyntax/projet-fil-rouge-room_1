package pfr.buycar.models;

/**
 * Énumération représentant les différents statuts possibles d'une commande.
 */
public enum StatutCommandeEnum {
    EN_ATTENTE,   // Commande créée mais pas encore confirmée
    CONFIRMEE,    // Commande validée et payée
    LIVREE,       // Commande livrée au client
    ANNULEE;      // Commande annulée par le client ou le vendeur
}
