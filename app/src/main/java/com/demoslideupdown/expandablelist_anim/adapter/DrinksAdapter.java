package com.demoslideupdown.expandablelist_anim.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demoslideupdown.R;
import com.demoslideupdown.expandablelist_anim.model.Drink;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DrinksAdapter extends RecyclerView.Adapter<DrinksAdapter.ViewHolder> {
    private List<Drink> beerList;

    DrinksAdapter (List<Drink> beerList) {
        this.beerList = beerList;
    }

    @NonNull
    @Override
    public DrinksAdapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_beer, parent,
                false);
        return new DrinksAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder (@NonNull DrinksAdapter.ViewHolder holder, final int position) {
        holder.bind(beerList.get(position));
    }

    @Override
    public int getItemCount () {
        return beerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvName)
        AppCompatTextView tvName;

        private ViewHolder (View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        private void bind (Drink beer) {
            tvName.setText(beer.getName());
        }
    }
}
