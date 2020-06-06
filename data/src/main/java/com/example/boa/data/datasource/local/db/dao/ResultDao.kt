package com.example.boa.data.datasource.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.boa.data.entity.ResultEntity

@Dao
interface ResultDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(resultEntity: ResultEntity)

    @Query("SELECT * FROM ResultEntity WHERE LOWER(term) LIKE :text")
    fun getByText(text: String): List<ResultEntity>

    @Query("SELECT * FROM ResultEntity WHERE id = :id")
    fun getById(id: Long): ResultEntity
}