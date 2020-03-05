package vfa.gaunau.practice.presentation.ui.main;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import vfa.gaunau.practice.R;
import vfa.gaunau.practice.presentation.ui.base.BaseFragment;

public class MainFragment extends BaseFragment {

    @BindView(R.id.bottomNav)
    BottomNavigationView bottomNav;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bottomNav.setOnNavigationItemSelectedListener(navItemListener);
    }

    private boolean init = false;

    private BottomNavigationView.OnNavigationItemSelectedListener navItemListener = item -> {
        Fragment fragment;
        switch (item.getItemId()) {

            default:
                return false;
        }
    };

}
