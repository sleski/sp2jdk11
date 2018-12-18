package it.tostao.sp2jdk11.services.Impl;

import it.tostao.sp2jdk11.entities.Car;
import it.tostao.sp2jdk11.services.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Slawomir Leski on 16-12-2018.
 */
@Service
public class CarsServiceImpl implements CarsService {

	private JdbcTemplate jdbcTemplate;

	public CarsServiceImpl(){

	}

	@Autowired
	public CarsServiceImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Car> all() {
		return null;
	}

	@Override
	public int countAll() {
		String query = "Select count(*) from car";
		Integer counter = jdbcTemplate.queryForObject(query, Integer.class);
		return 0;
	}
}
