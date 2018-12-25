package it.tostao.sp2jdk11.services;

import it.tostao.sp2jdk11.entities.Car;

import java.util.List;

/**
 * Created by Slawomir Leski on 16-12-2018.
 */
public interface CarService {

	List<Car> all();

	int countAll();

	int create(Car car);

	void update(Car car);
}
