package vfa.gaunau.practice.data.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class MedicationEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "date")
    public Date date;

    @ColumnInfo(name = "taken")
    public boolean taken;
}
