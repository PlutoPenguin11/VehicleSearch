package com.example.vehiclesearch.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vehiclesearch.R;
import com.example.vehiclesearch.data.VehicleRepository;
import com.example.vehiclesearch.viewmodel.VehicleViewModel;
import com.example.vehiclesearch.viewmodel.VehicleViewModelFactory;

public class MainActivity extends AppCompatActivity {
    private VehicleViewModel viewModel;
    private VehicleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editMake = findViewById(R.id.editMake);
        Button buttonSearch = findViewById(R.id.buttonSearch);
        TextView textStatus = findViewById(R.id.textStatus);
        RecyclerView recycler = findViewById(R.id.recyclerVehicles);

        adapter = new VehicleAdapter();
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);

        VehicleRepository repository = new VehicleRepository();
        VehicleViewModelFactory factory = new VehicleViewModelFactory(repository);
        viewModel = new ViewModelProvider(this,
                factory).get(VehicleViewModel.class);
        viewModel.getVehicles().observe(this,
                vehicles -> adapter.submitVehicles(vehicles));
        viewModel.getStatus().observe(this,
                textStatus::setText);

        buttonSearch.setOnClickListener(V ->
                viewModel.searchVehicles(
                        editMake.getText().toString()));
    }

}
