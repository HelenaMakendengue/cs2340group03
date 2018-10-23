package edu.gatech.cs2340.donationtracer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ItemViewHolder> {

    private ArrayList<Item> items;

    public ItemRecyclerAdapter(ArrayList<Item> items) {
        this.items = items;
}

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_item_scroller, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);

        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, final int position) {

        //bind data to widgets
        holder.itemDesc.setText(items.get(position).getShortDesc());
        holder.itemCategory.setText(items.get(position).getCategory().getRepresentation());

        //get location that corresponds to position
        holder.item = items.get(position);

        //user clicks on position
        /** holder.mView.setOnClickListener((v) -> {
            Context context = v.getContext();
            Toast.makeText(context, String.valueOf(position), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, LocationDetailActivity.class);
            intent.putExtra("location_name", holder.location.getName());
            intent.putExtra("location_type", holder.location.getType());
            intent.putExtra("location_longitude", holder.location.getLongitude());
            intent.putExtra("location_latitude", holder.location.getLatitude());
            intent.putExtra("location_address", holder.location.getAddress());
            intent.putExtra("location_number", holder.location.getNumber());

            context.startActivity(intent);
        }); */
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public TextView itemDesc;
        public TextView itemCategory;
        public Item item;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            itemDesc = itemView.findViewById(R.id.item_desc);
            itemCategory = itemView.findViewById(R.id.item_type);
        }

    }

}