package com.example.boa.data.datasource.local.db.dao

import androidx.room.*
import com.example.boa.data.entity.TermEntity

@Dao
interface TermDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(termEntity: TermEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(termEntity: TermEntity)

    @Delete
    fun delete(termEntity: TermEntity)

    @Query("SELECT * FROM TermEntity")
    fun getAll(): List<TermEntity>

    @Query("SELECT * FROM TermEntity WHERE text = :text")
    fun getByText(text: String): TermEntity
}