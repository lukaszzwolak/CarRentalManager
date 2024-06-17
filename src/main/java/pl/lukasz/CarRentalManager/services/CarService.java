package pl.lukasz.CarRentalManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukasz.CarRentalManager.entities.Car;
import pl.lukasz.CarRentalManager.repositories.CarRepository;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository vehicleRepository;

    public List<Car> getAllCars() {
        return vehicleRepository.findAll();
    }

    public Car getCarById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public Car saveCar(Car car) {
        return vehicleRepository.save(car);
    }

    public void deleteCar(Long id) {
        vehicleRepository.deleteById(id);
    }
}
