package vfa.gaunau.practice.presentation.ui.main;

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
import vfa.gaunau.practice.presentation.ui.profile.ProfileFragment;
import vfa.gaunau.practice.presentation.ui.today.TodayFragment;

public class MainFragment extends BaseFragment {

    @BindView(R.id.bottomNav)
    BottomNavigationView bottomNav;

    private TodayFragment todayFragment;
    private HistoryFragment historyFragment;
    private ExperienceFragment experienceFragment;
    private ProfileFragment profileFragment;

    private Fragment activeFragment;

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

        initFragment();

        bottomNav.setOnNavigationItemSelectedListener(navItemListener);
    }

    private boolean init = false;

    private void initFragment() {
        if (!init) {
            init = true;
            todayFragment = TodayFragment.newInstance();
            historyFragment = HistoryFragment.newInstance();
            experienceFragment = ExperienceFragment.newInstance();
            profileFragment = ProfileFragment.newInstance();

            // Transition to data transfer screen
            FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.add(R.id.container, todayFragment);
            fragmentTransaction.add(R.id.container, experienceFragment);
            fragmentTransaction.add(R.id.container, historyFragment);
            fragmentTransaction.add(R.id.container, profileFragment);
            //fragmentTransaction.add(R.id.container, activityFragment);

            fragmentTransaction.show(todayFragment);
            fragmentTransaction.hide(experienceFragment);
            fragmentTransaction.hide(historyFragment);
            fragmentTransaction.hide(profileFragment);
            //fragmentTransaction.hide(activityFragment);
            fragmentTransaction.commit();

            activeFragment = todayFragment;
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navItemListener = item -> {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.navOne:
                fragment = todayFragment;
                break;
            case R.id.navTwo:
                fragment = experienceFragment;
                break;
            case R.id.navThree:
                fragment = historyFragment;
                break;
            case R.id.navFour:
                fragment = profileFragment;
                break;
            default:
                return false;
        }

        // Screen Transition
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.hide(activeFragment);
        fragmentTransaction.show(fragment);
        fragmentTransaction.commit();

        activeFragment = fragment;

        return true;
    };

}
