package vfa.gaunau.practice.domain.repositories;

import androidx.lifecycle.LiveData;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import vfa.gaunau.practice.domain.model.Medication;

public interface MedicationRepo {

    LiveData<Medication> getMedicationByDate(Date date);

    Flowable<Boolean> insert(List<Medication> medications);

    Flowable<Boolean> insert(Medication medication);

    Flowable<Boolean> update(List<Medication> medications);

    Flowable<Boolean> update(Medication medication);

    LiveData<List<Medication>> findAll();

    Flowable<Boolean> deleteAll();
}
