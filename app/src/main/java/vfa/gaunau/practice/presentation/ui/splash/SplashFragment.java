package vfa.gaunau.practice.presentation.ui.splash;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import javax.inject.Inject;

import timber.log.Timber;
import vfa.gaunau.practice.R;
import vfa.gaunau.practice.presentation.di.Injectable;
import vfa.gaunau.practice.presentation.ui.base.BaseFragment;

public class SplashFragment extends BaseFragment implements Injectable, SplashViewModel.ViewListener {

    private SplashViewModel viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Setup ViewModel
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SplashViewModel.class);
        // Call listener
        viewModel.setViewListener(this);
        // Call init from ViewModel
        viewModel.init();
        setupStatusBar();
    }

    private void setupStatusBar() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requireActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_splash;
    }

    private Handler handler = new Handler();

    private void onEndLoading() {
        Timber.i("from Splash to Main");
        findNavController().navigate(SplashFragmentDirections.actionFrgSplashToFrgMain());
    }

    @Override
    public void onSettupDataSuccessful() {
        handler.postDelayed(this::onEndLoading, 1000);
    }

    @Override
    public void onNoNeedSetupData() {
        handler.postDelayed(this::onEndLoading, 2000);
    }
}