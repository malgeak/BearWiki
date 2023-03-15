package com.malgeak.bearwiki.presentation.ui;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.malgeak.bearwiki.R;
import com.malgeak.bearwiki.databinding.ActivityMainBinding;
import com.malgeak.bearwiki.presentation.ui.beermenu.BeerListFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.navHostFragmentContainer.getRootView());
    }

    public void setProgressLoader(Boolean value) {
        binding.progressBar.setVisibility(value ? View.VISIBLE: View.GONE);
    }

    @Override
    public void onBackPressed() {
        if (binding.navHostFragmentContainer.getFragment() instanceof BeerListFragment) {
            finishActivity(0);
        } else {
            super.onBackPressed();
        }
    }
}