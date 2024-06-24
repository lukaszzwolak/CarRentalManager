# Car Rental Manager

A comprehensive system for managing cars, clients, employees, invoices, and reservations.

## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [Setup](#setup)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features
- Add, edit, view, and delete cars
- Add, edit, view, and delete clients
- Manage employees and their information
- Generate and manage invoices
- Create and manage reservations

## Technologies
- Java 21
- Spring Boot
- Thymeleaf
- HTML

## Setup

### Prerequisites
- Java 21
- Maven

### Installation
1. Clone the repository
    ```bash
    git clone https://github.com/your-username/car-rental-manager.git
    ```
2. Navigate into the project directory
    ```bash
    cd car-rental-manager
    ```
3. Build the project with Maven
    ```bash
    mvn clean install
    ```

### Running the Application
1. Start the application
    ```bash
    mvn spring-boot:run
    ```
2. Open your browser and navigate to `http://localhost:8080`

## Usage

### Managing Cars
- **Add Car**: Navigate to `/car/add` and fill in the required fields to add a new car.
- **Edit Car**: Navigate to `/car/edit/{id}` where `{id}` is the ID of the car you want to edit.
- **View Cars**: Navigate to `/car/list` to see a list of all cars.
- **Delete Car**: Navigate to `/car/remove/{id}` where `{id}` is the ID of the car you want to delete.

### Managing Clients
- **Add Client**: Navigate to `/client/add` and fill in the required fields to add a new client.
- **Edit Client**: Navigate to `/client/edit/{id}` where `{id}` is the ID of the client you want to edit.
- **View Clients**: Navigate to `/client/list` to see a list of all clients.
- **Delete Client**: Navigate to `/client/remove/{id}` where `{id}` is the ID of the client you want to delete.

## Contributing
1. Fork the repository
2. Create a new branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Open a Pull Request

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.