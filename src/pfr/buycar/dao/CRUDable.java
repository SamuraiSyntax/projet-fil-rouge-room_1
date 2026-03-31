package pfr.buycar.dao;

import java.util.List;

/**
 * Interface générique pour définir les opérations CRUD de base.
 * @param <T> Le type d’objet manipulé par le DAO.
 */

public interface CRUDable<T> {
	
	    /**
	     * Crée un nouvel enregistrement dans la base de données.
	     * @param obj l’objet à ajouter
	     * @return true si l’opération réussit, false sinon
	     */
	    boolean create(T obj);
	    
	    /**
	     * Lit un enregistrement à partir de son identifiant.
	     * @param id l’identifiant unique de l’objet
	     * @return l’objet correspondant ou null s’il n’existe pas
	     */
	    T read(int id);

	    /**
	     * Met à jour un enregistrement existant.
	     * @param obj l’objet avec les nouvelles valeurs
	     * @return true si l’opération réussit, false sinon
	     */
	    boolean update(T obj);

	    /**
	     * Supprime un enregistrement par son identifiant.
	     * @param id l’identifiant unique de l’objet
	     * @return true si l’opération réussit, false sinon
	     */
	    boolean delete(int id);

	    /**
	     * Retourne la liste de tous les enregistrements.
	     * @return la liste complète des objets
	     */
	    List<T> getAll();
	    
}
