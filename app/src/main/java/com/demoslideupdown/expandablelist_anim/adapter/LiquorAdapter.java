package com.demoslideupdown.expandablelist_anim.adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demoslideupdown.expandablelist_anim.model.Beer;
import com.demoslideupdown.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.demoslideupdown.utils.AnimUtils.*;

public class LiquorAdapter extends RecyclerView.Adapter<LiquorAdapter.ViewHolder> {
    private List<Beer> beerList;

  private   List<View> views = new ArrayList<>();

    public LiquorAdapter (List<Beer> beerList) {
        this.beerList = beerList;
    }

    @NonNull
    @Override
    public LiquorAdapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_liquor, parent,
                false);

        return new LiquorAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder (@NonNull LiquorAdapter.ViewHolder holder, final int position) {
        holder.bind(beerList.get(position));
    }

    @Override
    public int getItemCount () {
        return beerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tvName)
        AppCompatTextView tvName;
        @BindView(R.id.clItem)
        ConstraintLayout clItem;
        @BindView(R.id.ivItem)
        AppCompatImageView ivItem;
        @BindView(R.id.rvDrinks)
        RecyclerView rvDrinks;

        private final View view;
        private final Context context;
        private boolean drinkBoolean = true;

        @OnClick(R.id.clItem)
        void onCLickItem (ConstraintLayout constraintLayout) {
            final int ti = getItemCount();
            int pos = getAdapterPosition();
            if (drinkBoolean) {
                ivItem.animate().rotation(-180).start();
                if (pos != ti - 1) {
                    slideDown(views.get(pos + 1), rvDrinks);
                } else {
                    animateViewToHide(rvDrinks);
                }

                drinkBoolean = false;
            } else {
                ivItem.animate().rotation(0).start();
                if (pos != ti - 1) {
                    slideUp(views.get(pos + 1), rvDrinks);
                } else {
                    animateViewToShow(rvDrinks);
                }
                drinkBoolean = true;
            }
        }

        private void bind (Beer beer) {

            tvName.setText(beer.getName());
            view.setId(beer.getId());
            views.add(view);

            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2, LinearLayoutManager.HORIZONTAL, false);
            rvDrinks.setLayoutManager(gridLayoutManager);
            rvDrinks.setHasFixedSize(false);

            if (beer.getDrink() != null && beer.getDrink().size() > 0) {
                DrinksAdapter beerAdapter = new DrinksAdapter(beer.getDrink());
                rvDrinks.setAdapter(beerAdapter);
            }

        }

        private ViewHolder (View view) {
            super(view);
            this.view = view;
            context = view.getContext();
            ButterKnife.bind(this, view);
        }
    }
}
