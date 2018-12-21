package it.tostao.sp2jdk11.services;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import it.tostao.sp2jdk11.entities.Car;
import it.tostao.sp2jdk11.services.Impl.CarServiceImpl;
import org.apache.commons.lang3.RandomStringUtils;
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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Slawomir Leski on 16-12-2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/sp2jdk11-test.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class CarServiceImplTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private CarServiceImpl carsService;

	@Before
	public void setUp() throws Exception {
		carsService = new CarServiceImpl(jdbcTemplate);
	}

	@Test
	@DatabaseSetup("/cars.xml")
	public void shouldCountNumberOfAllCars() throws Exception {
		int numberOfCars = carsService.countAll();
		Assert.assertEquals(numberOfCars, 2);
	}

	@Test
	public void shouldAddNewCar() {
		String brand = RandomStringUtils.randomAlphabetic(10);
		String model = RandomStringUtils.randomAlphabetic(5);
		Car car = new Car(brand, model);
		carsService.create(car);
		int numberOfCars = carsService.countAll();
		assertThat(numberOfCars, is(1));
	}
}
