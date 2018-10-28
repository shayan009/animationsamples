package com.demoslideupdown;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OptionAdapter extends RecyclerView.Adapter<OptionAdapter.OptionHolder> {

    private OnOptionClickListener<OptionModel> clickListener;
    private List<OptionModel> options;

    public OptionAdapter(OnOptionClickListener<OptionModel> clickListener) {
        this.clickListener = clickListener;
        this.options = OptionModel.getOptions();
    }

    @NonNull
    @Override
    public OptionAdapter.OptionHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new OptionHolder(
                LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_options, viewGroup, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull OptionAdapter.OptionHolder optionHolder, int i) {
        optionHolder.tvOptions.setText(options.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return options.size();
    }

    public class OptionHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvOptions)
        AppCompatTextView tvOptions;

        public OptionHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cardOptions)
        public void onClickOption(){
            clickListener.onClick(options.get(getAdapterPosition()));
        }
    }
}