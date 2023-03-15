package com.malgeak.bearwiki.presentation.ui.beermenu;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.malgeak.bearwiki.R;
import com.malgeak.bearwiki.data.model.BeerModel;
import com.malgeak.bearwiki.databinding.ItemBeerListBinding;

import java.util.ArrayList;
import java.util.List;

public class BeerAdpater extends RecyclerView.Adapter<BeerViewHolder> {

    private List<BeerModel> beerList;
    private OnBeerClickedListener mBeerClickedListener;

    public BeerAdpater(OnBeerClickedListener l) {
        this.mBeerClickedListener = l;
        beerList = new ArrayList<>();
    }

    public void setList(List<BeerModel> beerList) {
        this.beerList = beerList;
    }

    @NonNull
    @Override
    public BeerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBeerListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.item_beer_list, parent, false);
        return new BeerViewHolder(binding, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull BeerViewHolder holder, int position) {
        BeerModel beer = beerList.get(position);
        holder.bind(beer);
        if (mBeerClickedListener != null) {
            holder.binding.getRoot().setOnClickListener(view -> {
                    mBeerClickedListener.onBeerClicked(beer);
            });
        }
    }

    @Override
    public int getItemCount() {
        return beerList.size();
    }


}
