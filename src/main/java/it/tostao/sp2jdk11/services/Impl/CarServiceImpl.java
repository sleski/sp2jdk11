package it.tostao.sp2jdk11.services.Impl;

import it.tostao.sp2jdk11.entities.Car;
import it.tostao.sp2jdk11.mapper.CarMapper;
import it.tostao.sp2jdk11.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Slawomir Leski on 16-12-2018.
 */
@Service
public class CarServiceImpl implements CarService {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public CarServiceImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Car> all() {
		String query = "Select id, brand, model from car";
		List<Car> cars = jdbcTemplate.query(query, new CarMapper());
		return cars;
	}

	@Override
	public int countAll() {
		String query = "Select count(*) from car";
		Integer counter = jdbcTemplate.queryForObject(query, Integer.class);
		return counter;
	}

	@Override
	public void create(Car car) {
		String query = "Insert into car (brand, model) VALUES (?, ?)";
		jdbcTemplate.update(query, car.getBrand(), car.getModel());
	}

	@Override
	public void update(Car car) {
		String query = "UPDATE car brand = ? , model = ? where id = ?";
		jdbcTemplate.update(query, car.getBrand(), car.getModel(), car.getId());
	}
}
