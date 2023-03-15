package com.malgeak.bearwiki.presentation.ui.infobeer;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.malgeak.bearwiki.R;
import com.malgeak.bearwiki.databinding.ItemIngredientListBinding;

import java.util.List;
import java.util.Map;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientViewHolder> {

    private List<Pair<String, String>> ingredientsList;

    public IngredientsAdapter(List<Pair<String,String>> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemIngredientListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_ingredient_list, parent, false);
        return new IngredientViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {
        holder.bind(ingredientsList.get(position));
    }

    @Override
    public int getItemCount() {
        return ingredientsList.size();
    }
}
