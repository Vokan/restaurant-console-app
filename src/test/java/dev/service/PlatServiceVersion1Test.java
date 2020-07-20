package dev.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.dao.IPlatDao;

import dev.exception.PlatException;

public class PlatServiceVersion1Test {

	private PlatServiceVersion1 platServiceVersion1;
	IPlatDao platDao;
	
		@BeforeEach
		void setUp() {
			platDao=mock(IPlatDao.class);
			platServiceVersion1=new PlatServiceVersion1(platDao);
		}
		
		@Test
		void ajouterPlatNomInvalide() {
			assertThatThrownBy(() -> platServiceVersion1.ajouterPlat("lu", 4440))
			.isInstanceOf(PlatException.class)
			.hasMessage("un plat doit avoir un nom de plus de 3 caractères");

		}
		
		@Test
		void ajouterPlatPrixInvalide() {

			
			Assertions.assertThrows(PlatException.class, () -> platServiceVersion1.ajouterPlat("grain de blé", 20),
					"le prix d'un plat doit être supérieur à 5 €");
}
		@Test
		void ajouterPlatValide() {

			platServiceVersion1.ajouterPlat("chaussette", 4500);

			verify(platDao).ajouterPlat("chaussette", 4500);
}
}