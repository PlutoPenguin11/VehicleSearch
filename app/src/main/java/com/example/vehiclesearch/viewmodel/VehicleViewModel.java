package com.example.vehiclesearch.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.vehiclesearch.data.VehicleRepository;
import com.example.vehiclesearch.model.Vehicle;

import java.util.List;

public class VehicleViewModel extends ViewModel {
    private final VehicleRepository repository;
    private final MutableLiveData<List<Vehicle>> vehicles =
            new MutableLiveData<>();
    private final MutableLiveData<String> status =
            new MutableLiveData<>("Enter a make and tap search");

    public VehicleViewModel(VehicleRepository repository) {
        this.repository = repository;
    }

    public LiveData<List<Vehicle>> getVehicles() {
        return vehicles;
    }

    public LiveData<String> getStatus() {
        return status;
    }

    public void searchVehicles(String make) {
        List<Vehicle> matches = repository.searchByMake(make);
        vehicles.setValue(matches);
        status.setValue(matches.size() + " vehicle(s) found");
    }
}
