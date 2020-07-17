/**
 * 
 */
package dev.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.JdbcTestConfig;
import dev.entite.Plat;

/**
 * @author vokankocak
 *
 */

@SpringJUnitConfig(classes = {PlatDaoJdbc.class, JdbcTestConfig.class})
@ActiveProfiles("jdbc")
public class PlatDaoJdbcIntegrationTest extends IPlatDaoIntegrationTest {
			
	
}
