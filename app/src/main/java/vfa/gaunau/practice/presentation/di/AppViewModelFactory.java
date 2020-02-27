package vfa.gaunau.practice.presentation.di;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class AppViewModelFactory implements ViewModelProvider.Factory {

    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> creators;

    @Inject
    public AppViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> creators) {
        this.creators = creators;
    }

    /**
     * Creates a new instance of the given {@code Class}.
     * <p>
     *
     * @param modelClass a {@code Class} whose instance is requested
     * @return a newly created ViewModel
     */
    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> creator = findCreator(modelClass);
        if (creator == null) {
            throw new IllegalArgumentException("unknown model class $modelClass");
        }
        try {
            return (T) creator.getValue().get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private <T> Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> findCreator(@NonNull Class<T> modelClass) {
        for (Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> classProviderEntry : creators.entrySet()) {
            if (modelClass.isAssignableFrom(classProviderEntry.getKey())) {
                return classProviderEntry;
            }
        }
        return null;
    }
}
