package com.example.boa.data.datasource.local

import com.example.boa.data.datasource.TermDataSource
import com.example.boa.data.datasource.local.db.TheMovieDBDatabase
import com.example.boa.data.entity.TermEntity

class LocalTermDataSource(private val database: TheMovieDBDatabase) : TermDataSource {
    override suspend fun saveTerm(term: String): TermEntity {
        val entity = TermEntity()
        entity.text = term
        database.termDao().insert(entity)
        return entity
    }

    override suspend fun getTerms(): List<TermEntity> = database.termDao().getAll()
}