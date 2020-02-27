package vfa.gaunau.practice.presentation.di;

import android.widget.ExpandableListView;

import androidx.lifecycle.ViewModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dagger.MapKey;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@MapKey
public @interface ViewModelKey {
    //View model key nay se tu dong sinh ra mot Class View Model tuong ung khi mot ViewModel dc tao.
    Class<? extends ViewModel> value();
}
