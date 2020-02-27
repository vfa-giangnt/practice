package vfa.gaunau.practice.presentation.ui.base;

public interface IBase {
    void showLoading();

    void hideLoading();

    void handleThrowable(int errorCode, Throwable throwable);

    void handleEvent(int eventType);

    void openActivityOnTokenExpire();
}
