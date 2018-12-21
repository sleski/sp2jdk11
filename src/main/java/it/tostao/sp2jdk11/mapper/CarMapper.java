package it.tostao.sp2jdk11.mapper;

import it.tostao.sp2jdk11.entities.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Slawomir Leski on 21-12-2018.
 */
public class CarMapper implements RowMapper<Car> {

	@Override
	public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
		Car c = new Car();
		c.setBrand(rs.getString("brand"));
		c.setModel(rs.getString("model"));
		return c;
	}
}
