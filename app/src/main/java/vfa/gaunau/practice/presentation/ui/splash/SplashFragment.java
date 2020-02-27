package vfa.gaunau.practice.presentation.ui.splash;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import vfa.gaunau.practice.R;
import vfa.gaunau.practice.presentation.di.Injectable;
import vfa.gaunau.practice.presentation.ui.base.BaseFragment;

public class SplashFragment extends BaseFragment implements Injectable {

    private SplashViewModel viewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_splash;
    }

    private void onEndLoading() {

    }
}