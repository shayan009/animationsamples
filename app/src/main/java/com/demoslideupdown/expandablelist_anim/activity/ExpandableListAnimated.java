package com.demoslideupdown.expandablelist_anim.activity;

import android.animation.Animator;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.demoslideupdown.R;
import com.demoslideupdown.expandablelist_anim.adapter.BeerAdapter;
import com.demoslideupdown.expandablelist_anim.adapter.LiquorAdapter;
import com.demoslideupdown.expandablelist_anim.model.Beer;
import com.demoslideupdown.expandablelist_anim.model.Drink;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.demoslideupdown.utils.AnimUtils.animateViewToHide;
import static com.demoslideupdown.utils.AnimUtils.animateViewToShow;
import static com.demoslideupdown.utils.AnimUtils.slideDown;
import static com.demoslideupdown.utils.AnimUtils.slideUp;

public class ExpandableListAnimated extends AppCompatActivity {

    @BindView(R.id.rvBeerList)
    RecyclerView rvBeerList;
    @BindView(R.id.clLiquor)
    ConstraintLayout clLiquor;
    @BindView(R.id.clBeer)
    ConstraintLayout clBeer;
    @BindView(R.id.ivBeer)
    AppCompatImageView ivBeer;
    @BindView(R.id.ivLiquor)
    AppCompatImageView ivLiquor;
    @BindView(R.id.rvLiquorList)
    RecyclerView rvLiquorList;

    private boolean beerBoolean = true, liquorBoolean = true;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_animated);
        ButterKnife.bind(this);

        rvBeerList.setHasFixedSize(false);
        rvBeerList.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        rvBeerList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        populateBeer();

        rvLiquorList.setHasFixedSize(false);
        rvLiquorList.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        rvLiquorList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        populateLiquor();

    }

    private void populateBeer () {
        List<Beer> beers = new ArrayList<>();
        beers.add(new Beer(0, "Domestic", null));
        beers.add(new Beer(1, "Imported", null));
        beers.add(new Beer(2, "Cider", null));
        beers.add(new Beer(3, "Craft Beer", null));
        BeerAdapter beerAdapter = new BeerAdapter(beers);
        rvBeerList.setAdapter(beerAdapter);
    }

    private void populateLiquor () {
        List<Beer> beers = new ArrayList<>();

        List<Drink> drinkList1 = new ArrayList<>();
        drinkList1.add(new Drink(0, "Gin"));
        drinkList1.add(new Drink(0, "Bourbon"));

        List<Drink> drinkList2 = new ArrayList<>();
        drinkList2.add(new Drink(0, "Rum"));
        drinkList2.add(new Drink(0, "Vodka"));

        List<Drink> drinkList3 = new ArrayList<>();
        drinkList3.add(new Drink(0, "Whisky"));
        drinkList3.add(new Drink(0, "Wine"));


        beers.add(new Beer(0, "Well Drinks", drinkList1));
        beers.add(new Beer(1, "Cocktail", drinkList2));
        beers.add(new Beer(2, "House Specialities", drinkList3));
        beers.add(new Beer(3, "Top Shelf", null));
        LiquorAdapter liquorAdapter = new LiquorAdapter(beers);
        rvLiquorList.setAdapter(liquorAdapter);
    }

    
    @OnClick(R.id.clBeer)
    void onCheckBeer () {

        if (beerBoolean) {
            ivBeer.animate().rotationBy(-180)
                    .setDuration(500)
                    .setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            beerBoolean = false;
                        }
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            slideDown(clLiquor, rvBeerList);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    })
                    .start();

        } else {
            ivBeer.animate().rotationBy(180).setDuration(500)
                    .setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            beerBoolean = true;
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            slideUp(clLiquor, rvBeerList);

                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    })
                    .start();

        }

    }

    @OnClick(R.id.clLiquor)
    void onCheckLiquor () {
        if (liquorBoolean) {
            ivLiquor.animate().rotation(-180).start();
            animateViewToShow(rvLiquorList);
            liquorBoolean = false;
        } else {
            ivLiquor.animate().rotation(0).start();
            animateViewToHide(rvLiquorList);
            liquorBoolean = true;
        }
    }
}
