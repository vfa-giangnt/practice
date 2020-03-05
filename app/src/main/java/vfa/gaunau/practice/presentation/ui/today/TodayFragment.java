package vfa.gaunau.practice.presentation.ui.today;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import butterknife.BindView;
import timber.log.Timber;
import vfa.gaunau.practice.R;
import vfa.gaunau.practice.presentation.ui.base.BaseFragment;
import vfa.gaunau.practice.presentation.ui.experience.ExperienceFragment;
import vfa.gaunau.practice.presentation.ui.history.HistoryFragment;
import vfa.gaunau.practice.presentation.ui.main.MainFragmentDirections;
import vfa.gaunau.practice.presentation.ui.profile.ProfileFragment;

public class TodayFragment extends BaseFragment {

    @BindView(R.id.bottom_sheet)
    RelativeLayout bottomSheet;

    @BindView(R.id.cardView)
    CardView cardView;

    @BindView(R.id.title)
    AppCompatTextView title;

    private BottomSheetBehavior sheetBehavior;

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

        sheetBehavior = BottomSheetBehavior.from(bottomSheet);
        cardView.setOnClickListener(v -> {
            Timber.d("Hi there");
            if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            } else{
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        // callback for do something
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        title.setText("Close Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        title.setText("Expand Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });

    }

    private boolean init = false;

}
