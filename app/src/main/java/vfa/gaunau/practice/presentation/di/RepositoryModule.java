package vfa.gaunau.practice.presentation.di;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import vfa.gaunau.practice.data.repository.MedicationRepositoryImpl;
import vfa.gaunau.practice.domain.repositories.MedicationRepo;

@Module
public interface RepositoryModule {
    @Binds
    @Singleton
    MedicationRepo bindMedicationRepository(MedicationRepositoryImpl repo);
}
