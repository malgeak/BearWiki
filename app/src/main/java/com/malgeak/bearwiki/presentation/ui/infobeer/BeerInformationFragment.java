package com.malgeak.bearwiki.presentation.ui.infobeer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.malgeak.bearwiki.R;
import com.malgeak.bearwiki.data.model.BeerModel;
import com.malgeak.bearwiki.databinding.FragmentBeerInformationBinding;

import java.util.ArrayList;

public class BeerInformationFragment extends Fragment {

    private BeerModel beerModel;
    private FragmentBeerInformationBinding binding;
    NavController navigation;
    PageAdapter pageAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String json = getArguments().getString("beerModel");
            beerModel = new Gson().fromJson(json, BeerModel.class);
        }
        navigation = NavHostFragment.findNavController(this);
        pageAdapter = new PageAdapter(getChildFragmentManager());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_beer_information, container, false);
        binding.setBeerModel(beerModel);
        configViewPager();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addActions();
        setImage();
        binding.tabLayout.setupWithViewPager(binding.pager);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void addActions() {
        binding.buttonBack.setOnClickListener(view -> {
            navigation.navigateUp();
        });
    }



    public void setImage() {
        Glide.with(requireContext())
                .load(beerModel.getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(binding.imageViewBeer);
    }

    public void configViewPager() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(getString(R.string.title_section1));
        arrayList.add(getString(R.string.title_section2));

        MaltIngredientsFragment maltIngredientsFragment = new MaltIngredientsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("maltModel", new Gson().toJson(beerModel.getIngredients().getMalt()));
        maltIngredientsFragment.setArguments(bundle);

        pageAdapter.addFragmet(maltIngredientsFragment, arrayList.get(0));

        HopsIngredientsFragment hopsIngredientsFragment = new HopsIngredientsFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("hopsModel", new Gson().toJson(beerModel.getIngredients().getHops()));
        hopsIngredientsFragment.setArguments(bundle2);

        pageAdapter.addFragmet(hopsIngredientsFragment, arrayList.get(1));

        binding.pager.setAdapter(pageAdapter);
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}