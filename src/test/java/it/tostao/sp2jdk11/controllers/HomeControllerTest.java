package it.tostao.sp2jdk11.controllers;

import it.tostao.sp2jdk11.services.Impl.CarServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Slawomir Leski on 13-12-2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerTest {

	private MockMvc mockMvc;

	@Mock
	private CarServiceImpl carService;

	@Before
	public void setup() {
		carService = mock(CarServiceImpl.class);
		this.mockMvc = MockMvcBuilders.standaloneSetup(new HomeController(carService)).build();
	}

	@Test
	public void testSayHelloWorld() throws Exception {
		this.mockMvc.perform(get("/").accept(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE))).andExpect(status().isOk());
	}
}
