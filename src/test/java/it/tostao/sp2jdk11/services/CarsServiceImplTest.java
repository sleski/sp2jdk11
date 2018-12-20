package it.tostao.sp2jdk11.services;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import it.tostao.sp2jdk11.services.Impl.CarsServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * Created by Slawomir Leski on 16-12-2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/sp2jdk11-test.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class CarsServiceImplTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private CarsServiceImpl carsService;

	@Before
	public void setUp() throws Exception {
		carsService = new CarsServiceImpl(jdbcTemplate);
	}

	@Test
	@DatabaseSetup("cars.xml")
	public void shouldCountNumberOfAllCars() throws Exception {
		int numberOfCars = carsService.countAll();
		Assert.assertEquals(numberOfCars, 2);
	}
}
