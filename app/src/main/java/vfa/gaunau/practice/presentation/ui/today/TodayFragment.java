package vfa.gaunau.practice.presentation.ui.today;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import vfa.gaunau.practice.R;
import vfa.gaunau.practice.presentation.ui.base.BaseFragment;
import vfa.gaunau.practice.presentation.ui.experience.ExperienceFragment;
import vfa.gaunau.practice.presentation.ui.history.HistoryFragment;
import vfa.gaunau.practice.presentation.ui.main.MainFragmentDirections;
import vfa.gaunau.practice.presentation.ui.profile.ProfileFragment;

public class TodayFragment extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_today;
    }

    public static TodayFragment newInstance() {
        return new TodayFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btnSettings).setOnClickListener(v -> {
            findNavController().navigate(MainFragmentDirections.actionFrgMainToFrgDetail());
        });
    }

    private boolean init = false;

}
