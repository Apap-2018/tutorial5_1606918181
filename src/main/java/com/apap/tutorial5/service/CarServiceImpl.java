package com.apap.tutorial5.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial5.model.CarModel;
import com.apap.tutorial5.repository.CarDb;

@Service
@Transactional
public class CarServiceImpl implements CarService{
	@Autowired
	private CarDb carDb;
	
	@Override
	public void addCar(CarModel car) {
		carDb.save(car);
	}

	@Override
	public CarModel getCar(long id) {
		return carDb.findById(id).get();
	}

	@Override
	public void deleteCar(CarModel car) {
		// TODO Auto-generated method stub
		carDb.delete(car);
	}

	@Override
	public void updateCar(long id, CarModel newCar) {
		// TODO Auto-generated method stub
		CarModel car = carDb.getOne(id);
		car.setBrand(newCar.getBrand());
		car.setType(newCar.getType());
		car.setPrice(newCar.getPrice());
		car.setAmount(newCar.getAmount());
		carDb.save(car);
	}

	@Override
	public List<CarModel> sortByPrice(Long dealerId) {
		return carDb.findByDealerIdOrderByPriceDesc(dealerId);
	}
}
