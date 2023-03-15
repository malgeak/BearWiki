package com.malgeak.bearwiki.presentation.ui.infobeer;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.malgeak.bearwiki.R;
import com.malgeak.bearwiki.data.model.ingredients.Hop;
import com.malgeak.bearwiki.databinding.FragmentIngredientsListBinding;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HopsIngredientsFragment extends Fragment {

    private List<Hop> maltModelList;
    private IngredientsAdapter adapter;
    FragmentIngredientsListBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String json = getArguments().getString("hopsModel");
            Type listType = new TypeToken<List<Hop>>() {}.getType();
            maltModelList = new Gson().fromJson(json, listType);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ingredients_list, container, true);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createListIngredients();
    }

    public void createListIngredients() {
        ArrayList<Pair<String,String>> ingredientList = new ArrayList<>();

        for (Hop hop : maltModelList) {
            ingredientList.add(new Pair<>(hop.getName(), hop.getAmount().getValue()+" "+hop.getAmount().getUnit()));
        }

        adapter = new IngredientsAdapter(ingredientList);
        binding.recyclerViewContainer.setAdapter(adapter);
        binding.recyclerViewContainer.setLayoutManager(new LinearLayoutManager(requireContext()));
    }
}
