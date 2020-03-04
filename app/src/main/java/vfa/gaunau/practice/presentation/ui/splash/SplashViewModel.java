package vfa.gaunau.practice.presentation.ui.splash;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class SplashViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    @Inject
    SplashViewModel() {

    }

    // region === ViewListener ===
    private ViewListener listener;

    public void setViewListener(ViewListener listener) {
        this.listener = listener;
    }

    public void init() {
        if (listener != null)
            listener.onNoNeedSetupData();
    }

    public interface ViewListener {
        void onSettupDataSuccessful();

        void onNoNeedSetupData();
    }
    // endregion

}
