package vfa.gaunau.practice.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import vfa.gaunau.practice.data.db.entities.MedicationEntity;

@Dao
public interface MedicationDao {

    /*
     * PHẢI NHỚ IMPLEMENT HẾT CHỪNG NÀY METHOD THÌ MỚI KO BỊ TOANG AT RUNTIME
     */

    // Lớp này mô tả các phương thức mà Object Medication cần để thao tác trên dữ liệu của nó với database

    // Get All Medication from DB
    // => Return livedata list Medication
    @Query("SELECT * FROM MedicationEntity")
    LiveData<List<MedicationEntity>> getAll();

    // delete
    @Delete
    void delete(MedicationEntity entity);

    // Delete all
    @Query("DELETE FROM MedicationEntity")
    void deleteAll();

    // getData by condition filter
    @Query("SELECT * FROM MedicationEntity WHERE date BETWEEN :dayStart AND :dayEnd")
    LiveData<MedicationEntity> getMedicationByDate(long dayStart, long dayEnd);

    // Update
    @Query("UPDATE MedicationEntity SET taken= :isTaken WHERE id = :id")
    void update(int id, boolean isTaken);

    // Update or Insert data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertOrUpdate(MedicationEntity entity);

    @Insert
    void insert(MedicationEntity entity);

    @Insert
    void insertAll(List<MedicationEntity> entities);

    @Update
    void update(MedicationEntity entity);
}
