function loadVehicles() {
    fetch('http://localhost:8080/vehicles')
        .then(response => response.json())
        .then(data => {
            const vehicleList = document.getElementById('vehicleList');
            vehicleList.innerHTML = '';
            data.forEach(vehicle => {
                const listItem = document.createElement('li');
                listItem.textContent = `${vehicle.make} ${vehicle.model} - ${vehicle.licensePlate}`;
                vehicleList.appendChild(listItem);
            });
        });
}

function addVehicle() {
    const make = document.getElementById('make').value;
    const model = document.getElementById('model').value;
    const licensePlate = document.getElementById('licensePlate').value;

    fetch('http://localhost:8080/vehicles', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({make, model, licensePlate}),
    })
        .then(response => response.json())
}
