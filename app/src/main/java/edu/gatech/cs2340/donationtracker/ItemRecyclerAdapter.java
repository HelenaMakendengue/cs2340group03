package edu.gatech.cs2340.donationtracker;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * ItemRecyclerAdapter sets the model for adapters.
 */
public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ItemViewHolder> {

    private final List<Item> items;

    /**
     * Constructor for the ItemRecyclerAdapter
     * @param items a list of items to be displayed
     */
    public ItemRecyclerAdapter(List<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressWarnings("ChainedMethodCall") View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_item_scroller, parent, false);

        return new ItemViewHolder(view);
    }

    @SuppressWarnings("ChainedMethodCall")
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, final int position) {

        //bind data to widgets
        //noinspection ChainedMethodCall
        holder.itemDesc.setText(items.get(position).getShortDesc());
        //noinspection ChainedMethodCall,ChainedMethodCall
        holder.itemCategory.setText(items.get(position).getCategory().getRepresentation());

        //get location that corresponds to position
        holder.item = items.get(position);

        //user clicks on position
        holder.mView.setOnClickListener((v) -> {
            Context context = v.getContext();
            Toast.makeText(context, String.valueOf(position), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, ItemDetailActivity.class);
            intent.putExtra("item_timeStamp", holder.item.getTimestamp());
            //noinspection ChainedMethodCall
            intent.putExtra("item_locname", holder.item.getLocation().getName());
            intent.putExtra("item_shortDesc", holder.item.getShortDesc());
            intent.putExtra("item_fullDesc", holder.item.getFullDesc());
            intent.putExtra("item_category", holder.item.getCategory().toString());
            //noinspection ChainedMethodCall
            intent.putExtra("item_dollarValue", holder.item.getDollarValue().toString());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView itemDesc;
        final TextView itemCategory;
        Item item;

        ItemViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            itemDesc = itemView.findViewById(R.id.item_desc);
            itemCategory = itemView.findViewById(R.id.item_type);
        }

    }

}