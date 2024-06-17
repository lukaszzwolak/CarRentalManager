package pl.lukasz.CarRentalManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.lukasz.CarRentalManager.entities.*;
import pl.lukasz.CarRentalManager.services.CarService;

import java.util.List;

@RestController
public class CarController {
    //wstrzykiwanie instancji carservice
    @Autowired
    private CarService carService;

    @GetMapping("/car")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }
    // Get car by ID
    @GetMapping("/car/{id}")
    public String getCarById(@PathVariable Long id) {
        return carService.getCarById(id).toString();
    }

    // Create a new car
    @PostMapping("/car/{model}")
    public String createCar(@RequestBody String model) {
        Car car = new Car();
        car.setModel(model);
        carService.saveCar(car);
        return "to jest dodane auto" + car.getId();
    }

    // Update a car
    @PutMapping("/car/{id}/{name}")
    public String updateCar(@PathVariable Long id, @RequestBody String model) {
        Car car = carService.getCarById(id);
        car.setModel(model);
        return car.toString();
    }

    // Delete a car
    @DeleteMapping("/car/delete/{id}")
    public void deleteCar(@PathVariable Long id) {
        Car car = carService.getCarById(id);
        carService.deleteCar(id);
    }
}
