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

import static com.demoslideupdown.utils.AnimUtils.*;

public class LiquorAdapter  extends RecyclerView.Adapter<LiquorAdapter.ViewHolder> {
    private List<Beer> beerList;
    Context context;
             List<View> views=new ArrayList<>();
    public LiquorAdapter(Context context) {
        this.context = context;
    }
    public LiquorAdapter(Context context,List<Beer> beerList) {
        this.context = context;
        this.beerList = beerList;
    }

    public void setBeerList(List<Beer> beerList) {
        this.beerList = beerList;
    }

    @NonNull
    @Override
    public LiquorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_liquor, parent,
                false);

        return new LiquorAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull LiquorAdapter.ViewHolder holder, final int position) {
        holder.bind(beerList.get(position),position);
    }

    @Override
    public int getItemCount() {
        return beerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View view;
        private AppCompatTextView tvName;
        private ConstraintLayout clItem;
        private AppCompatImageView ivItem;
        private RecyclerView rvDrinks;
        private boolean drinkBoolean=true;
        private void bind(Beer beer, final int pos) {
            tvName.setText(beer.getName());
            view.setId(beer.getId());
            views.add(view);
         
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context,2,LinearLayoutManager.HORIZONTAL,false);
            rvDrinks.setLayoutManager(gridLayoutManager);
            rvDrinks.setHasFixedSize(false);
         final int ti=   getItemCount();
            if(beer.getDrink()!=null&&beer.getDrink().size()>0){
                DrinksAdapter beerAdapter= new  DrinksAdapter(context, beer.getDrink());
                rvDrinks.setAdapter(beerAdapter);
                clItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(drinkBoolean){
                            ivItem.animate().rotation(-180).start();
                            if(pos!=ti-1){
                                slideDown(views.get(pos+1),rvDrinks);
                            }   else
                            {
                                animateViewToHide(rvDrinks);
                            }

                            drinkBoolean=false;
                        } else{
                            ivItem.animate().rotation(0).start();
                            if(pos!=ti-1){
                                slideUp(views.get(pos+1),rvDrinks);
                            }
                            else{
                                animateViewToShow(rvDrinks);
                            }

                            drinkBoolean=true;
                        }
                    }
                });
            }

        }

        private ViewHolder(View view) {
            super(view);
            this.view=view;
            clItem = view.findViewById(R.id.clItem);
            tvName=view.findViewById(R.id.tvName);
            ivItem=view.findViewById(R.id.ivItem);
            rvDrinks=view.findViewById(R.id.rvDrinks);
        }
    }
}
