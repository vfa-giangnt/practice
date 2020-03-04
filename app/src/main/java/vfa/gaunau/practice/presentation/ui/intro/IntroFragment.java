package vfa.gaunau.practice.presentation.ui.intro;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vfa.gaunau.practice.R;
import vfa.gaunau.practice.presentation.ui.base.BaseFragment;

public class IntroFragment extends BaseFragment {

    private IntroViewModel viewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_intro;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
