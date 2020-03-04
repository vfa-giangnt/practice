package vfa.gaunau.practice.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import vfa.gaunau.practice.data.db.AppDatabase;
import vfa.gaunau.practice.data.db.dao.MedicationDao;
import vfa.gaunau.practice.data.db.entities.MedicationEntity;
import vfa.gaunau.practice.data.db.mapper.MedicationMapper;
import vfa.gaunau.practice.domain.model.Medication;
import vfa.gaunau.practice.domain.repositories.MedicationRepo;
import vfa.gaunau.practice.utils.Utility;

public class MedicationRepositoryImpl implements MedicationRepo {

    private MedicationDao dao;

    public MedicationRepositoryImpl(AppDatabase appDatabase) {
        this.dao = appDatabase.medicationDao();
    }

    @Override
    public LiveData<Medication> getMedicationByDate(Date date) {
        long startDate = Utility.getStartDateTimeStamp(date);
        long endDate = Utility.getEndDateTimeStamp(date);

        return Transformations.map(dao.getMedicationByDate(startDate, endDate), MedicationMapper::transform);
    }

    @Override
    public Flowable<Boolean> insert(List<Medication> medications) {
        return Flowable.create(emitter -> {
            try {
                List<MedicationEntity> entities = new ArrayList<>();
                for (int i = 0; i < medications.size(); i++) {
                    entities.add(MedicationMapper.transform(medications.get(i)));
                }
                dao.insertAll(entities);
                emitter.onNext(true);
                emitter.onComplete();

            } catch (Exception ex) {
                emitter.onError(ex);
            }
        }, BackpressureStrategy.BUFFER);
    }

    @Override
    public Flowable<Boolean> insert(Medication medication) {
        return Flowable.create(emitter -> {
            try {
                dao.insert(MedicationMapper.transform(medication));
                emitter.onNext(true);
                emitter.onComplete();
            } catch (Exception ex) {
                emitter.onError(ex);
            }
        }, BackpressureStrategy.BUFFER);
    }

    @Override
    public Flowable<Boolean> update(List<Medication> medications) {
        return null;
    }

    @Override
    public Flowable<Boolean> update(Medication medication) {
        return null;
    }

    @Override
    public LiveData<List<Medication>> findAll() {
        return null;
    }

    @Override
    public Flowable<Boolean> deleteAll() {
        return null;
    }


}
