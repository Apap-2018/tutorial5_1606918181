package com.apap.tutorial5.service;

import java.util.List;

import com.apap.tutorial5.model.CarModel;

public interface CarService {
	void addCar(CarModel car);
	CarModel getCar(long id);
	void deleteCar(CarModel car);
	void updateCar(long id, CarModel car);
	List<CarModel> sortByPrice(Long dealerId);
}