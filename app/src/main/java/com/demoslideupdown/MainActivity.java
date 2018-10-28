package com.demoslideupdown;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.demoslideupdown.expandablelist_anim.activity.ExpandableListAnimated;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnOptionClickListener<OptionModel> {

    @BindView(R.id.recyclerOptions)
    RecyclerView recyclerOptions;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context = this;

        recyclerOptions.setLayoutManager(new LinearLayoutManager(context));
        recyclerOptions.setHasFixedSize(true);
        recyclerOptions.setAdapter(new OptionAdapter(this));
    }

    @Override
    public void onClick(OptionModel data) {

        switch (data.getId()) {
            case 1:
                startActivity(new Intent(context, ExpandableListAnimated.class));
                break;
            default:
                Toast.makeText(context, "Wrong Options", Toast.LENGTH_SHORT).show();
        }
    }
}
