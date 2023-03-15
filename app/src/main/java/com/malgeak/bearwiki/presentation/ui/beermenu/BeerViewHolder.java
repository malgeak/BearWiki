package com.malgeak.bearwiki.presentation.ui.beermenu;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.malgeak.bearwiki.data.model.BeerModel;
import com.malgeak.bearwiki.databinding.ItemBeerListBinding;

public class    BeerViewHolder extends RecyclerView.ViewHolder {
    ItemBeerListBinding binding;
    Context context;

    public BeerViewHolder(ItemBeerListBinding binding, Context context) {
        super(binding.getRoot());
        this.binding = binding;
        this.context = context;
    }

    public void bind(BeerModel beer) {
        Glide.with(context)
                .load(beer.getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(binding.imageViewBeer);

        binding.textViewTitleBeer.setText(beer.getName());
        binding.textViewDescriptionBeer.setText(beer.getDescription());
    }
}
