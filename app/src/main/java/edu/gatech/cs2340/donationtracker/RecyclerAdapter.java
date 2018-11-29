package edu.gatech.cs2340.donationtracker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Recycler Adapter class displays the locations and its inventory.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.LocationViewHolder> {

    private final List<Location> locations;

    //public DatabaseReference databaseLocations;

    /**
     * A recycler adapter constructor with one param
     * @param locations the map containing location number and location objects
t     */
    public RecyclerAdapter(Map<Integer, Location> locations) {
        this.locations = new ArrayList<>(locations.values());
        //this.databaseLocations = FirebaseDatabase.getInstance().getReference("locations");
    }

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_layout, parent, false);
        return new LocationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, final int position) {

        //bind data to widgets
        holder.locationName.setText(locations.get(position).getName());
        holder.locationAddress.setText(locations.get(position).getAddress());

        //get location that corresponds to position
        holder.location = locations.get(position);

        //user clicks on position
        holder.mView.setOnClickListener((v) -> {
            Context context = v.getContext();
            Toast.makeText(context, String.valueOf(position),Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, LocationDetailActivity.class);
            intent.putExtra("location_name", holder.location.getName());
            intent.putExtra("location_type",holder.location.getType().toString());
            intent.putExtra("location_longitude",holder.location.getLongitude());
            intent.putExtra("location_latitude",holder.location.getLatitude());
            intent.putExtra("location_address",holder.location.getAddress());
            intent.putExtra("location_number",holder.location.getNumber());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    public static class LocationViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView locationName;
        final TextView locationAddress;
        Location location;

        LocationViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            locationName = itemView.findViewById(R.id.location_name);
            locationAddress = itemView.findViewById(R.id.address);

        }

    }
}
