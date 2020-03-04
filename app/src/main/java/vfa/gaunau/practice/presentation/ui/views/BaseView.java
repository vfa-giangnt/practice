package vfa.gaunau.practice.presentation.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import butterknife.ButterKnife;

abstract public class BaseView<T extends ViewDataBinding> extends LinearLayout {
    protected AttributeSet attrs;
    protected T binding;
    public BaseView(Context context) {
        super(context);
        setLayout(context, null);

    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayout(context, attrs);
    }
    private void setLayout(Context context, @Nullable AttributeSet attrs) {
        this.attrs = attrs;
        View viewRoot = LayoutInflater.from(context).inflate(getLayoutId(), this, false);
        addView(viewRoot);
        ButterKnife.bind(this);
        binding = DataBindingUtil.bind(viewRoot);
        setupUI();
    }
    protected Context requireContext(){
        return getContext();
    }
    @LayoutRes
    abstract protected int getLayoutId();

    abstract protected void setupUI();

}
