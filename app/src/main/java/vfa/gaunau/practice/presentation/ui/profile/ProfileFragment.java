package vfa.gaunau.practice.presentation.ui.profile;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import javax.inject.Inject;

import vfa.gaunau.practice.R;
import vfa.gaunau.practice.presentation.ui.base.BaseFragment;
import vfa.gaunau.practice.presentation.ui.detail.DetailViewModel;
import vfa.gaunau.practice.presentation.ui.main.MainFragment;

public class ProfileFragment extends BaseFragment implements DetailViewModel.ViewListener {

    private DetailViewModel viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_profile;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CollapsingToolbarLayout layout = view.findViewById(R.id.collapsingToolbarLayout);
        NavController navController = Navigation.findNavController(requireActivity(), R.id.navHostFragment);
        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph()).build();
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        NavigationUI.setupWithNavController(layout, toolbar, navController, appBarConfiguration);
    }

    @Override
    public void onListener() {

    }
}
