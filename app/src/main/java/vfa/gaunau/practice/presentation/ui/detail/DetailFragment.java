package vfa.gaunau.practice.presentation.ui.detail;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import vfa.gaunau.practice.R;
import vfa.gaunau.practice.presentation.ui.base.BaseFragment;
import vfa.gaunau.practice.presentation.ui.splash.SplashViewModel;

public class DetailFragment extends BaseFragment implements DetailViewModel.ViewListener {

    private DetailViewModel viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_detail;
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
        // Setup ViewModel
        /*viewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel.class);
        // Call listener
        viewModel.setViewListener(this);
        // Call init from ViewModel
        viewModel.init();*/
    }

    @Override
    public void onListener() {

    }
}
