package com.example.vehiclesearch.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.vehiclesearch.R;
import com.example.vehiclesearch.model.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class VehicleAdapter extends
        RecyclerView.Adapter<VehicleAdapter.VehicleHolder> {

    private final List<Vehicle> items = new ArrayList<>();

    public void submitVehicles(List<Vehicle> vehicles) {
        items.clear();
        if (vehicles != null) items.addAll(vehicles);
        notifyDataSetChanged();
    }

    @NonNull @Override
    public VehicleHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_vehicle, parent, false);
        return new VehicleHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull VehicleHolder holder, int position) {
        Vehicle vehicle = items.get(position);
        holder.name.setText(
                vehicle.getMake() + " " + vehicle.getModel());
        holder.year.setText("Year: " + vehicle.getYear());
    }

    @Override public int getItemCount() { return items.size(); }

    static class VehicleHolder extends RecyclerView.ViewHolder {
        final TextView name;
        final TextView year;

        VehicleHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textVehicleName);
            year = itemView.findViewById(R.id.textVehicleYear);
        }
    }
}

