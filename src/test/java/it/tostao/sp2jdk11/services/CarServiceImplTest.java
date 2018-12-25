package it.tostao.sp2jdk11.services;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import it.tostao.sp2jdk11.entities.Car;
import it.tostao.sp2jdk11.services.Impl.CarServiceImpl;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Slawomir Leski on 16-12-2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/sp2jdk11-test.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
@DatabaseSetup("/cars.xml")
public class CarServiceImplTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Before
	public void setUp() throws Exception {
		carsService = new CarServiceImpl(jdbcTemplate);
	}

	private CarServiceImpl carsService;

	@Test
	public void shouldCountNumberOfAllCars() throws Exception {
		int numberOfCars = carsService.countAll();
		assertThat(numberOfCars, is(2));
	}

	@Test
	public void shouldAddNewCar() {
		int numberOfCars = carsService.countAll();
		assertThat(numberOfCars, is(2));
		String brand = RandomStringUtils.randomAlphabetic(10);
		String model = RandomStringUtils.randomAlphabetic(5);
		Car car = new Car(brand, model);
		carsService.create(car);
		numberOfCars = carsService.countAll();
		assertThat(numberOfCars, is(3));
	}

	@Test
	public void shouldGetAllCars() throws Exception {
		List<Car> cars = carsService.all();
		assertThat(cars.size(), is(2));
	}

	@Test
	public void shouldUpdateCar() throws Exception {
		String brand = RandomStringUtils.randomAlphabetic(10);
		String model = RandomStringUtils.randomAlphabetic(10);
		Car car = new Car(brand, model);

	}
}
