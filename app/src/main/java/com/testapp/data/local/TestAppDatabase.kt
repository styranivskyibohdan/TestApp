package com.testapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.testapp.data.local.dao.ArticleDao
import com.testapp.domain.db.Article

@Database(
    entities = [Article::class],
    version = 1
)
abstract class TestAppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}