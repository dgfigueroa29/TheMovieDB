package com.example.boa.data.datasource.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.boa.data.datasource.local.db.dao.ResultDao
import com.example.boa.data.datasource.local.db.dao.TermDao
import com.example.boa.data.entity.ResultEntity
import com.example.boa.data.entity.TermEntity

@Database(
    entities = [TermEntity::class, ResultEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TheMovieDBDatabase : RoomDatabase() {
    abstract fun termDao(): TermDao
    abstract fun resultDao(): ResultDao

    companion object {
        private const val DATABASE_NAME = "APP_THE_MOVIE_DB_DATABASE"
        private var INSTANCE: TheMovieDBDatabase? = null

        fun getAppDatabase(context: Context): TheMovieDBDatabase? {
            if (INSTANCE == null) {
                synchronized(TheMovieDBDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        TheMovieDBDatabase::class.java,
                        DATABASE_NAME
                    ).build()
                }
            }

            return INSTANCE
        }
    }
}