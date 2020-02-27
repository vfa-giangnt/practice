package vfa.gaunau.practice.presentation.ui.base;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import vfa.gaunau.practice.utils.Utility;

public abstract class BaseActivity extends AppCompatActivity implements IBase {

    private AlertDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    protected abstract int getLayoutId();

    @Override
    public void showLoading() {
        if (loadingDialog == null) {
//            loadingDialog = DialogUtil.showLoading(this);
        } else {
            if (!loadingDialog.isShowing()) {
                loadingDialog.show();
            }
        }
    }

    @Override
    public void hideLoading() {
        loadingDialog.dismiss();
    }

    @Override
    public void handleThrowable(int errorCode, Throwable throwable) {

    }

    @Override
    public void handleEvent(int eventType) {

    }

    @Override
    public void openActivityOnTokenExpire() {

    }

    public boolean setHideKeyboardOnClickOutside() {
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View vFocus = getCurrentFocus();
        boolean result = super.dispatchTouchEvent(ev);

        if (vFocus instanceof EditText) {
            View view = getCurrentFocus();
            if (view != null) {
                int[] scroords = new int[2];
                view.getLocationOnScreen(scroords);
                float x = ev.getRawX() + view.getLeft() - scroords[0];
                float y = ev.getRawY() + view.getTop() - scroords[1];

                if (ev.getAction() == MotionEvent.ACTION_UP
                        && (x < view.getLeft() || x >= view.getRight() || y < view.getTop() || y > view.getBottom())
                        && setHideKeyboardOnClickOutside()) {
                    Utility.hideKeyboard(this, view);
                }
            }
        }
        return result;
    }
}
