package pl.lukasz.CarRentalManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lukasz.CarRentalManager.entities.Car;
import pl.lukasz.CarRentalManager.services.CarService;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    //wstrzykiwanie instancji carservice
    @Autowired
    private CarService carService;
    //uzywanie carService wo wywolania encji Car zamiast bezpośrednio wywoływać metody repozytorium
    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    // Get car by ID
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Car car = carService.getCarById(id);
        return car != null ? ResponseEntity.ok(car) : ResponseEntity.notFound().build();
    }

    // Create a new car
    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    // Update a car
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car carDetails) {
        Car car = carService.getCarById(id);
        if (car != null) {
            car.setModel(carDetails.getModel());
            Car updatedCar = carService.saveCar(car);
            return ResponseEntity.ok(updatedCar);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a car
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        Car car = carService.getCarById(id);
        if (car != null) {
            carService.deleteCar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
