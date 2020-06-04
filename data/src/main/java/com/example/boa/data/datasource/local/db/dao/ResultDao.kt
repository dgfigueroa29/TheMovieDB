package com.example.boa.data.datasource.local.db.dao

import androidx.room.*
import com.example.boa.data.entity.ResultEntity

@Dao
interface ResultDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(resultEntity: ResultEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(resultEntity: ResultEntity)

    @Delete
    fun delete(resultEntity: ResultEntity)

    @Query("SELECT * FROM ResultEntity")
    fun getAll(): List<ResultEntity>
}