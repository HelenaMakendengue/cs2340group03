package edu.gatech.cs2340.donationtracer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.LocationViewHolder> {

    private HashMap<Integer, Location> locations;

    public RecyclerAdapter(HashMap<Integer, Location> locations) {
        this.locations = locations;
    }


    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_layout, parent, false);
        LocationViewHolder locationViewHolder = new LocationViewHolder(view);

        return locationViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    public static class LocationViewHolder extends RecyclerView.ViewHolder {
        TextView locationName;

        public LocationViewHolder(View itemView) {
            super(itemView);
            locationName = itemView.findViewById(R.id.location_name);
        }

    }
}
