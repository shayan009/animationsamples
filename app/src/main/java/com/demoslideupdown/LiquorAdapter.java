package com.demoslideupdown;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;
import java.util.List;

import static com.demoslideupdown.AnimUtils.*;

public class LiquorAdapter  extends RecyclerView.Adapter<LiquorAdapter.ViewHolder> {
    private List<Beer> beerList;
    Context context;

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
        holder.bind(beerList.get(position));
    }

    @Override
    public int getItemCount() {
        return beerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView tvName;
        private AppCompatCheckBox cbCheckItem;
        private ConstraintLayout clItem;
        private AppCompatCheckBox chbItem;
        private RecyclerView rvDrinks;
        private void bind(Beer beer) {
            cbCheckItem.setChecked(!beer.isChecked());
            tvName.setText(beer.getName());

            GridLayoutManager gridLayoutManager = new GridLayoutManager(context,2,LinearLayoutManager.HORIZONTAL,false);
            rvDrinks.setLayoutManager(gridLayoutManager);
            rvDrinks.setHasFixedSize(false);
            setUpDrinks();
            chbItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animation animation= AnimationUtils.loadAnimation(context, R.anim.rotation);
                    animation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            if (chbItem.isChecked()) {
                                animateViewToShow(rvDrinks);
                            } else {
                                animateViewToHide(rvDrinks);
                            }
                        }
                        @Override
                        public void onAnimationEnd(Animation animation) {


                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    chbItem.startAnimation(animation);
                }
            });
        }

        private void setUpDrinks() {
            List<Beer> beers=new ArrayList<>();
            beers.add(new Beer(0,"Gin",false));
            beers.add(new Beer(1,"Bourbon",false));
            beers.add(new Beer(2,"Rum",false));
            beers.add(new Beer(3,"Tequila",false));
            beers.add(new Beer(4,"Vodka",false));
            beers.add(new Beer(5,"Vermouth",false));
            beers.add(new Beer(6,"Whisky",false));
            beers.add(new Beer(7,"Scotch",false));
            beers.add(new Beer(8,"Wine",false));
            BeerAdapter beerAdapter= new  BeerAdapter(context,beers);
            rvDrinks.setAdapter(beerAdapter);
        }

        private ViewHolder(View view) {
            super(view);
            cbCheckItem = view.findViewById(R.id.cbCheckItem);
            clItem = view.findViewById(R.id.clItem);
            tvName=view.findViewById(R.id.tvName);
            chbItem=view.findViewById(R.id.chbItem);
            rvDrinks=view.findViewById(R.id.rvDrinks);
        }
    }
}