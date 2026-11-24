package com.example.vehiclesearch.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.vehiclesearch.data.VehicleRepository;

public class VehicleViewModelFactory
        implements ViewModelProvider.Factory {
    private final VehicleRepository repository;

    public VehicleViewModelFactory(VehicleRepository repository) {
        this.repository = repository;
    }

    @NonNull @Override
    public <T extends ViewModel> T create(
            @NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(VehicleViewModel.class)) {
            return modelClass.cast(
                    new VehicleViewModel(repository));
        }
        throw new IllegalArgumentException("Unknown ViewModel");
    }
}
