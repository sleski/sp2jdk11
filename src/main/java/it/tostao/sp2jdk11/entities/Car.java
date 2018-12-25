package it.tostao.sp2jdk11.entities;

/**
 * Created by Slawomir Leski on 17-12-2018.
 */
public class Car {

	public Car(){

	}

	public Car(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}


	private long id;
	private String brand;
	private String model;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
