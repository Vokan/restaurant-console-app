package dev.service;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;

import dev.dao.IPlatDao;
import dev.dao.PlatDaoMemoire;

public class PlatServiceVersion1Test {

	private PlatServiceVersion1 platServiceVersion1;
	IPlatDao platDao;
	
		@BeforeEach
		void setUp() {
			platDao=mock(IPlatDao.class);
			platServiceVersion1=new PlatServiceVersion1(platDao);
		}
}
