//package pl.lukasz.CarRentalManager.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import pl.lukasz.CarRentalManager.entities.Client;
//import pl.lukasz.CarRentalManager.services.ClientService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/customers")
//public class CustomerController {
//    @Autowired
//    private ClientService customerService;
//
//    @GetMapping
//    public List<Client> getAllCustomers() {
//        return customerService.getAllCustomers();
//    }
//
//    @GetMapping("/{id}")
//    public Client getCustomerById(@PathVariable Long id) {
//        return customerService.getCustomerById(id);
//    }
//
//    @PostMapping
//    public Client createCustomer(@RequestBody Client customer) {
//        return customerService.saveCustomer(customer);
//    }
//
//    @PutMapping("/{id}")
//    public Client updateCustomer(@PathVariable Long id, @RequestBody Client customer) {
//        Client existingCustomer = customerService.getCustomerById(id);
//        if (existingCustomer != null) {
//            customer.setId(id);
//            return customerService.saveCustomer(customer);
//        }
//        return null;
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteCustomer(@PathVariable Long id) {
//        customerService.deleteCustomer(id);
//    }
//}