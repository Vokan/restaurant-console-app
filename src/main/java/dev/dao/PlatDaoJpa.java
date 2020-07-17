/**
 * 
 */
package dev.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.entite.Plat;

/**
 * @author vokankocak
 *
 */
@Repository
@Profile("jpa")
public class PlatDaoJpa implements IPlatDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Plat> listerPlats() {
		TypedQuery<Plat> query = entityManager.createQuery("FROM Plat", Plat.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void ajouterPlat(String nomPlat, Integer prixPlat) {
		Plat plat = new Plat();
		plat.setNom(nomPlat);
		plat.setPrixEnCentimesEuros(prixPlat);
		entityManager.persist(plat);
		
	}

}
