/**
 * 
 */
package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;

import dev.entite.Plat;

/**
 * @author vokankocak
 *
 */

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class IPlatDaoIntegrationTest {
	
	@Autowired 
	private IPlatDao dao;
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Test
	void listerPlatsNonVide() {
		List<Plat> plats = dao.listerPlats();
		assertThat(plats).isNotEmpty();
	}
	
	
	@Test
	void ajouterPlat() {
		dao.ajouterPlat("sushi", 800);
		String sql = "SELECT prix FROM plat WHERE nom = 'sushi'";
		Integer prix = jdbc.queryForObject(sql, Integer.class);
		assertThat(prix).isEqualTo(800);
	}
}
