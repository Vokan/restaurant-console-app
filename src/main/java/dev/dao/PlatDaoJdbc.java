/**
 * 
 */
package dev.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import dev.entite.Plat;

/**
 * @author vokankocak
 *
 */
@Repository
@Profile("platDoaJdbc")
public class PlatDaoJdbc implements IPlatDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public PlatDaoJdbc(DataSource datasource) { 
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<Plat> listerPlats() {
		
		RowMapper<Plat> mapper = (ResultSet rs, int rowNum) -> { 
			Plat plat1 = new Plat();
		
			plat1.setNom(rs.getString("NOM")); 
			plat1.setPrixEnCentimesEuros(rs.getInt("prixEnCentimesEuros"));
			return plat1;
		
			};
	
			String sql = "SELECT NOM, prixEnCentimesEuros FROM PLAT";
			List<Plat> plats = this.jdbcTemplate.query(sql, mapper);
			return plats;
			}
	
			@Override
			public void ajouterPlat(String nomPlat, Integer prixPlat) {
				String sql = "INSERT INTO PLAT (NOM, prixEnCentimesEuros) VALUE(Pizza, 30000)";
				jdbcTemplate.update(sql, nomPlat, prixPlat);
		
	}

}
