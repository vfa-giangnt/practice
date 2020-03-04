package vfa.gaunau.practice.data.db.mapper;

import vfa.gaunau.practice.data.db.entities.MedicationEntity;
import vfa.gaunau.practice.domain.model.Medication;

public class MedicationMapper {

    public static Medication transform(MedicationEntity entity) {
        if (entity == null)
            return null;

        Medication model = new Medication();
        model.setId(entity.id);
        model.setDate(entity.date);
        model.setTaken(entity.taken);

        return model;
    }

    public static MedicationEntity transform(Medication model) {
        MedicationEntity entity = new MedicationEntity();

        entity.id = model.getId();
        entity.date = model.getDate();
        entity.taken = model.isTaken();

        return entity;
    }
}
