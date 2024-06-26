package pl.lukasz.CarRentalManager.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Invoice> invoices;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @NotBlank(message = "Model is required")
    @Size(min = 2, message = "Model must be at least 2 characters")
    private String model;

    @NotBlank(message = "Brand is required")
    @Size(min = 2, message = "Brand must be at least 2 characters")
    private String brand;

    @NotBlank(message = "Registration number is required")
    @Pattern(regexp="[A-Z]{2}-[0-9]{4,6}", message = "Invalid registration number format")
    private String registrationNumber;

    @NotNull(message = "Status is required")
    private Status status;

    public Car() {
        status = Status.Available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public @NotBlank(message = "Model is required") @Size(min = 2, message = "Model must be at least 2 characters") String getModel() {
        return model;
    }

    public void setModel(@NotBlank(message = "Model is required") @Size(min = 2, message = "Model must be at least 2 characters") String model) {
        this.model = model;
    }

    public @NotBlank(message = "Brand is required") @Size(min = 2, message = "Brand must be at least 2 characters") String getBrand() {
        return brand;
    }

    public void setBrand(@NotBlank(message = "Brand is required") @Size(min = 2, message = "Brand must be at least 2 characters") String brand) {
        this.brand = brand;
    }

    public @NotBlank(message = "Registration number is required") @Pattern(regexp = "[A-Z]{2}-[0-9]{4,6}", message = "Invalid registration number format") String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(@NotBlank(message = "Registration number is required") @Pattern(regexp = "[A-Z]{2}-[0-9]{4,6}", message = "Invalid registration number format") String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDisplayName() {
        return brand + " " + model + "(" + registrationNumber + ")";
    }
}