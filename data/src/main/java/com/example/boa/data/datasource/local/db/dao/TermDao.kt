package com.example.boa.data.datasource.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.boa.data.entity.TermEntity

@Dao
interface TermDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(termEntity: TermEntity)

    @Query("SELECT * FROM TermEntity")
    fun getAll(): List<TermEntity>
}