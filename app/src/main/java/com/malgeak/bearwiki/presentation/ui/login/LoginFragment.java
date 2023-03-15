package com.malgeak.bearwiki.presentation.ui.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.malgeak.bearwiki.R;
import com.malgeak.bearwiki.databinding.FragmentLoginBinding;
import com.malgeak.bearwiki.di.Injector;
import com.malgeak.bearwiki.presentation.ui.MainActivity;

import javax.inject.Inject;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private NavController navigation;
    @Inject
    LoginViewModelFactory viewModelFactory;
    private LoginViewModel viewModel;

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((Injector) requireContext().getApplicationContext())
                .createLoginSubcomponent()
                .inject(this);

        viewModel = new ViewModelProvider(this, viewModelFactory).get(LoginViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_login, container, false);
        binding.setViewmodel(viewModel);
        navigation = NavHostFragment.findNavController(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createObservers();
        createActions();

    }

    private void createActions() {
        binding.buttonLoginSigup.setOnClickListener(view -> {

            viewModel.onClickButton(binding.textInputLayoutUserName.getEditText().getText().toString(),
                    binding.textInputLayoutPassword.getEditText().getText().toString());
        });
    }

    private void createObservers() {
        viewModel.getLoader().observe(getViewLifecycleOwner(), show -> {
            ((MainActivity) requireActivity()).setProgressLoader(show);
        });

        viewModel.getPasswordError().observe(getViewLifecycleOwner(), error -> {
            binding.textInputLayoutPassword.setError(null);
            if (!error) {
                int message = (viewModel.getUserName().getValue() == null) ? R.string.error_invalid_password_message : R.string.error_wrong_password_message;
                binding.textInputLayoutPassword.setError(getString(message));
            }
        });

        viewModel.getUserNameError().observe(getViewLifecycleOwner(), error -> {
            binding.textInputLayoutUserName.setError(null);
            if (!error) {
                binding.textInputLayoutUserName.setError(getString(R.string.error_invalid_username_message));
            }
        });

        viewModel.getLogin().observe(getViewLifecycleOwner(), login -> {
            if (login) {
                navigation.navigate(R.id.action_loginFragment_to_beerListFragment);
            }
        });
    }
}