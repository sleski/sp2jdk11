package it.tostao.sp2jdk11.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.tostao.sp2jdk11.entities.Car;
import it.tostao.sp2jdk11.services.Impl.CarServiceImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * Created by Slawomir Leski on 28-12-2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Before
	public void setup() {
		CarServiceImpl carsService = new CarServiceImpl(jdbcTemplate);
		this.mockMvc = MockMvcBuilders.standaloneSetup(new CarController(carsService)).build();
	}

	@Ignore
	@Test
	public void shouldAddNewCar() throws Exception {
		Car car = new Car("Audi","TT");
		ObjectMapper objectMapper = new ObjectMapper();
		String carToSend = objectMapper.writeValueAsString(car);
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/car/add").contentType(MediaType.APPLICATION_JSON_UTF8).content(carToSend)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertThat(status, is(201));
	}
}
