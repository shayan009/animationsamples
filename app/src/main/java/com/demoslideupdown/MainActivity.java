package com.demoslideupdown;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import java.util.ArrayList;
import java.util.List;

import static com.demoslideupdown.AnimUtils.*;

public class MainActivity extends AppCompatActivity {


    private int mShortAnimationDuration=150;
    @BindView(R.id.rvBeerList)
    RecyclerView rvBeerList;

    @BindView(R.id.clLiquor)
    ConstraintLayout clLiquor;

    @BindView(R.id.clBeer)
    ConstraintLayout clBeer;


    @BindView(R.id.chbBeer)
    AppCompatCheckBox chbBeer;

    @BindView(R.id.chbLiquor)
    AppCompatCheckBox chbLiquor;

    @BindView(R.id.rvLiquorList)
    RecyclerView rvLiquorList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        rvBeerList.setHasFixedSize(false);
        rvBeerList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        populateBeer();


        rvLiquorList.setHasFixedSize(false);
        rvLiquorList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        populateLiquor();

    }

    private void populateLiquor() {
        List<Beer> beers=new ArrayList<>();
        beers.add(new Beer(0,"Well Drinks",false));
        beers.add(new Beer(1,"Cocktail",false));
        beers.add(new Beer(2,"House Specialities",false));
        beers.add(new Beer(3,"Top Shelf",true));
        beers.add(new Beer(4,"Call Drinks",false));
        LiquorAdapter liquorAdapter= new  LiquorAdapter(getApplicationContext(),beers);
        rvLiquorList.setAdapter(liquorAdapter);
    }

    private void populateBeer() {
        List<Beer> beers=new ArrayList<>();
        beers.add(new Beer(0,"Domestic",true));
        beers.add(new Beer(1,"Imported",false));
        beers.add(new Beer(2,"Cider",false));
        beers.add(new Beer(3,"Craft Beer",false));
        BeerAdapter beerAdapter= new  BeerAdapter(getApplicationContext(),beers);
        rvBeerList.setAdapter(beerAdapter);
    }
    @OnClick(R.id.chbBeer)
    void onCheckBeer(){
        Animation animation= AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if (chbBeer.isChecked()) {
                    slideDown(clLiquor,rvBeerList);
                } else {
                    slideUp(clLiquor,rvBeerList);
                }
            }
            @Override
            public void onAnimationEnd(Animation animation) {


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        chbBeer.startAnimation(animation);
    }

    @OnClick(R.id.chbLiquor)
    void onCheckLiquor(){
        Animation animation= AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if (chbLiquor.isChecked()) {
                    animateViewToShow(rvLiquorList);
                } else {
                    animateViewToHide(rvLiquorList);
                }
            }
            @Override
            public void onAnimationEnd(Animation animation) {


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        chbLiquor.startAnimation(animation);
    }



}
