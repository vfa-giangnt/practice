package vfa.gaunau.practice.presentation.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import butterknife.ButterKnife;

abstract public class BaseFragment extends Fragment implements IBase {
    private IBase iBase;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @LayoutRes
    protected abstract int getLayoutId();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof IBase) {
            iBase = (IBase) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        iBase = null;
    }

    protected ActionBar getActionBar() {
        return ((AppCompatActivity) requireActivity()).getSupportActionBar();
    }

    protected NavController findNavController() {
        return NavHostFragment.findNavController(this);
    }

    // region ===> Implement IBase <===
    public IBase getiBase() {
        return iBase;
    }

    @Override
    public void showLoading() {
        assert iBase != null;
        iBase.showLoading();
    }

    @Override
    public void hideLoading() {
        assert iBase != null;
        iBase.hideLoading();
    }

    @Override
    public void openActivityOnTokenExpire() {

    }

    @Override
    public void handleEvent(int eventType) {

    }

    @Override
    public void handleThrowable(int errorCode, Throwable throwable) {

    }
    // endregion

//    // region ===> Show Toast <===
//    protected void showToast(String msg) {
//        showToast(msg, Toast.LENGTH_SHORT);
//    }
//
//    protected void showToast(@StringRes int msgRes) {
//        showToast(getString(msgRes), Toast.LENGTH_SHORT);
//    }
//
//    protected void showLongToast(String msg) {
//        showToast(msg, Toast.LENGTH_LONG);
//    }
//
//    protected void showLongToast(@StringRes int msgRes) {
//        showToast(getString(msgRes), Toast.LENGTH_LONG);
//    }
//
//    private void showToast(String msg, int duration) {
//        Toast.makeText(requireActivity(), msg, duration).show();
//    }
//    // endregion
}
