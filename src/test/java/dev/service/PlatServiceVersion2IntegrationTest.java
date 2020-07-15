/**
 * 
 */
package dev.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.dao.PlatDaoMemoire;
import dev.entite.Plat;
import dev.exception.PlatException;

/**
 * @author vokankocak
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {PlatServiceVersion2.class,PlatDaoMemoire.class})
public class PlatServiceVersion2IntegrationTest {
		
	@Autowired
	PlatServiceVersion2 serviceVersion2;
	
	@Test
	void ajouterPlatValide() {
		serviceVersion2.ajouterPlat("Une blanquette de veau", 10000);
		List<Plat> resultat = serviceVersion2.listerPlats();
		Assertions.assertNotNull(resultat);
	}
	@Test
	void ajouterPlatPasValide() {
		assertThatThrownBy (() -> serviceVersion2.ajouterPlat("rotiee", 11))
		.isInstanceOf(PlatException.class)
		.hasMessage("le prix d'un plat doit être supérieur à 10 €");

}
}