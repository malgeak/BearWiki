package com.malgeak.bearwiki.presentation.ui.beermenu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.malgeak.bearwiki.R;
import com.malgeak.bearwiki.data.model.BeerModel;
import com.malgeak.bearwiki.databinding.FragmentBeerListBinding;
import com.malgeak.bearwiki.di.Injector;
import com.malgeak.bearwiki.presentation.ui.MainActivity;

import java.util.List;

import javax.inject.Inject;

public class BeerListFragment extends Fragment implements OnBeerClickedListener {

    private FragmentBeerListBinding binding;
    @Inject
    public BeerListViewModelFactory viewModelFactory;
    private BeerListViewModel viewModel;
    private NavController navigation;
    private BeerAdpater beerAdpater;


    public static BeerListFragment newInstance(String param1, String param2) {
        BeerListFragment fragment = new BeerListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((Injector) requireContext().getApplicationContext())
                .createBeerSubcomponent()
                .inject(this);
        viewModel = new ViewModelProvider(this, viewModelFactory).get(BeerListViewModel.class);
        navigation = NavHostFragment.findNavController(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_beer_list, container, false);
        navigation = NavHostFragment.findNavController(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createObservers();
        createActions();
        createRecyclerView();
        viewModel.getBeerListFromRepository();
    }

    private void createActions() {
        binding.includedToolbar.buttonUpdate.setOnClickListener(view -> {
        viewModel.updateBeerList();
        });
    }

    private void createObservers() {
        viewModel.getLoader().observe(getViewLifecycleOwner(), show -> {
            ((MainActivity) requireActivity()).setProgressLoader(show);
        });

        viewModel.getBeerList().observe(getViewLifecycleOwner(), beerList -> {
            beerAdpater.setList(beerList);
            beerAdpater.notifyDataSetChanged();
        });

        viewModel.getBeerSelected().observe(getViewLifecycleOwner(), beerModel -> {
            Bundle bundle = new Bundle();
            bundle.putString("beerModel", new Gson().toJson(beerModel));
            navigation.navigate(R.id.action_beerListFragment_to_beerInformationFragment, bundle);
        });
    }

    public void createRecyclerView() {
        beerAdpater = new BeerAdpater(this);
        binding.recyclerViewBeerListContainer.setAdapter(beerAdpater);
        binding.recyclerViewBeerListContainer.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    @Override
    public void onBeerClicked(BeerModel beerModel) {
        viewModel.selectedBer(beerModel);
    }


}