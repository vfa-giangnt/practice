package vfa.gaunau.practice.presentation.ui.detail;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class DetailViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    @Inject
    DetailViewModel() {

    }

    // region === ViewListener ===
    private ViewListener listener;

    public void setViewListener(ViewListener listener) {
        this.listener = listener;
    }

    public void init() {
        if (listener != null)
            listener.onListener();
    }

    public interface ViewListener {
        void onListener();
    }
    // endregion

}
