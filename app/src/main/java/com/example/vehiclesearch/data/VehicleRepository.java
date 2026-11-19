package com.example.vehiclesearch.data;

import com.example.vehiclesearch.model.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class VehicleRepository {
    private final List<Vehicle> vehicles = Arrays.asList(
            new Vehicle("Toyota", "Camry", 2024),
            new Vehicle("Toyota", "Corolla", 2023)
    );

    public List<Vehicle> searchByMake(String query) {
        String search = query == null ? "" :
                query.trim().toLowerCase(Locale.ROOT);
        List<Vehicle> matches = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (search.isEmpty() ||
                vehicle.getMake().toLowerCase(Locale.ROOT)
                        .contains(search)) {
                matches.add(vehicle);
            }
        }
        return matches;
    }
}
