/**
 * 
 */
package dev.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author vokankocak
 *
 */

@Configuration
@Import({JpaConfig.class, JdbcTestConfig.class})
public class JpaTestConfig {

	
		
}