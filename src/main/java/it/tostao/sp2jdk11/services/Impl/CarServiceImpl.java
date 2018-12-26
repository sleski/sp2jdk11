package it.tostao.sp2jdk11.services.Impl;

import it.tostao.sp2jdk11.entities.Car;
import it.tostao.sp2jdk11.mapper.CarMapper;
import it.tostao.sp2jdk11.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
	public int create(Car car) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String query = "Insert into car (brand, model) VALUES (?, ?)";
		jdbcTemplate.update(new MyPreparedStatementCreator(query, car), keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public void update(Car car) {
		String query = "UPDATE car brand = ? , model = ? where id = ?";
		jdbcTemplate.update(query, car.getBrand(), car.getModel(), car.getId());
	}

	private static class MyPreparedStatementCreator implements PreparedStatementCreator {
		private final String query;
		private final Car car;

		public MyPreparedStatementCreator(String query, Car car) {
			this.query = query;
			this.car = car;
		}

		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement ps = con.prepareStatement(query, new String[]{"id"});
			ps.setString(1, car.getBrand());
			ps.setString(2, car.getModel());
			return ps;
		}
	}
}
