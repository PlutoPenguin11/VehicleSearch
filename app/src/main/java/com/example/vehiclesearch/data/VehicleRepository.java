package com.example.vehiclesearch.data;

public class VehicleRepository {
    private final List<Vehicle> vehicles = Array.asList(
            new Vehicle("Toyota", "Camry", 2024),
            new Vehicle("Toyota", "Corolla", 2023)
    );

    public List<Vehicle> searchByMake(String query) {
        String search = query == NULL ? "" :
                query.trim().toLowerCase(Local.ROOT);
        List<Vehicle> matches = new Arraylist<>();
        for (Vehicle vehicle : vehicles) {
            if (search.isEmpty() ||
                vehicle.getMake().toLowerCase(Locale.ROOT)
                        .contains(search)) {
                matches.add(vehicle);
            }
        }
        return vehicles;
    }
}
