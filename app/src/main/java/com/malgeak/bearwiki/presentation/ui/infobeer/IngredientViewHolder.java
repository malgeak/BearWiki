package com.malgeak.bearwiki.presentation.ui.infobeer;

import android.util.Pair;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.malgeak.bearwiki.databinding.ItemIngredientListBinding;

import java.util.Map;

public class IngredientViewHolder extends RecyclerView.ViewHolder {

    private ItemIngredientListBinding binding;
    public IngredientViewHolder(ItemIngredientListBinding root) {
        super(root.getRoot());
        this.binding = root;
    }

    public void bind(Pair<String, String> ingredient) {
        binding.textViewNameIngredient.setText(ingredient.first);
        binding.textViewValue.setText(ingredient.second);
    }
}
