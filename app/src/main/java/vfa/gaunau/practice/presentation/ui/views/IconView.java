package vfa.gaunau.practice.presentation.ui.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import vfa.gaunau.practice.R;
import vfa.gaunau.practice.databinding.ViewIconBinding;


public class IconView extends BaseView<ViewIconBinding> {

    public IconView(Context context) {
        super(context);
    }

    public IconView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.view_icon;
    }

    @Override
    protected void setupUI() {
        @SuppressLint("CustomViewStyleable")
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.IconViewStyle);
        //int bgColor = typedArray.getColor(R.styleable.SquareViewStyle_bgColor, ContextCompat.getColor(getContext(),R.color.grey_500));
        Drawable icon = typedArray.getDrawable(R.styleable.IconViewStyle_ivIcon);
        typedArray.recycle();


        binding.setIcon(icon);
    }
    public void setIcon(Drawable icon){
        binding.setIcon(icon);
    }
}
