package com.example.boa.data.datasource

import com.example.boa.data.entity.ResultEntity

interface ResultDataSource {
    suspend fun saveResult(resultEntity: ResultEntity)
    suspend fun getResultsByTerm(term: String): List<ResultEntity>
    suspend fun getById(id: Long): ResultEntity
}