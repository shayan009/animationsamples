package com.demoslideupdown;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.demoslideupdown.expandablelist_anim.activity.ExpandableListAnimated;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToExpandedAnimated (View view) {
        startActivity(new Intent(MainActivity.this, ExpandableListAnimated.class));
    }
}
