package com.demoslideupdown;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class DrinksAdapter  extends RecyclerView.Adapter<DrinksAdapter.ViewHolder> {
    private List<Drink> beerList;
    Context context;

    public DrinksAdapter(Context context) {
        this.context = context;
    }
    public DrinksAdapter(Context context,List<Drink> beerList) {
        this.context = context;
        this.beerList = beerList;
    }

    public void setBeerList(List<Drink> beerList) {
        this.beerList = beerList;
    }

    @NonNull
    @Override
    public DrinksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_beer, parent,
                false);
        return new DrinksAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull DrinksAdapter.ViewHolder holder, final int position) {
        holder.bind(beerList.get(position));
    }

    @Override
    public int getItemCount() {
        return beerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView tvName;

        private void bind(Drink beer) {
            tvName.setText(beer.getName());
        }
        private ViewHolder(View view) {
            super(view);
            tvName=view.findViewById(R.id.tvName);
        }
    }
}
