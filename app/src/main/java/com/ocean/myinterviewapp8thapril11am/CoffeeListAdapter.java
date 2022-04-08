package com.ocean.myinterviewapp8thapril11am;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ocean.myinterviewapp8thapril11am.databinding.CustomItemListBinding;

import java.util.List;

public class CoffeeListAdapter extends RecyclerView.Adapter<CoffeeListAdapter.MyViewHolder> {

    Context context;
    List<CoffeeModel> list;

    public CoffeeListAdapter(Context context, List<CoffeeModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CoffeeListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        CustomItemListBinding binding = CustomItemListBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeListAdapter.MyViewHolder holder, int position) {
        holder.binding.tvDescription.setText(list.get(position).getDescription());
        holder.binding.tvTittle.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CustomItemListBinding binding;
        public MyViewHolder(@NonNull CustomItemListBinding itemView) {
            super(itemView.getRoot());

            binding = itemView;
        }
    }
}
