package vfa.gaunau.practice.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import vfa.gaunau.practice.data.db.converter.DateConverter;
import vfa.gaunau.practice.data.db.converter.MessageTypeConverter;
import vfa.gaunau.practice.data.db.dao.MedicationDao;
import vfa.gaunau.practice.data.db.entities.MedicationEntity;

@Database(entities = {
        MedicationEntity.class
}, version = 1)
@TypeConverters({DateConverter.class, MessageTypeConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract MedicationDao medicationDao();
}