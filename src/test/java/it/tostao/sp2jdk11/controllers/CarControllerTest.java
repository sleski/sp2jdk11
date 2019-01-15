package it.tostao.sp2jdk11.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.tostao.sp2jdk11.entities.Car;
import it.tostao.sp2jdk11.services.Impl.CarServiceImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Slawomir Leski on 28-12-2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarControllerTest {

	private MockMvc mockMvc;

	@Mock
	private CarServiceImpl carsService;

	@Before
	public void setup() {
		carsService = mock(CarServiceImpl.class);
		this.mockMvc = MockMvcBuilders.standaloneSetup(new CarController(carsService)).build();
	}

	@Test
	public void shouldCountCarsNumber() throws Exception {
		when(carsService.countAll()).thenReturn(5);
		MvcResult mvcResult = this.mockMvc.perform(get("/car/counter").accept(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE)))
				.andExpect(status().isOk()).andReturn();
		String response = mvcResult.getResponse().getContentAsString();//andExpecrt(content().json("{5}"));
		System.out.println("" + response);
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
