package pl.lukasz.CarRentalManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import pl.lukasz.CarRentalManager.entities.*;
import pl.lukasz.CarRentalManager.services.CarService;


@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService service;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("cars", service.getAllCars());
        return "car-list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("car", new Car());
        return "car-add";
    }

    @PostMapping("/add")
    public String add(Car car) {
        service.saveCar(car);
        return "redirect:/car/list";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Car car = service.getCarById(id);
        model.addAttribute("car", car);
        return "car-edit";
    }

    @PostMapping("/edit")
    public String edit(Car car) {
        service.saveCar(car);
        return "redirect:/car/list";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
        Car car = service.getCarById(id);
        model.addAttribute("car", car);
        return "car-remove";
    }

    @PostMapping("/remove")
    public String remove(Car car) {
        service.deleteCar(car.getId());
        return "redirect:/car/list";
    }
}
