package com.harikrish.newsing.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.harikrish.newsing.model.Article

@Database(entities = [Article::class], version = 1)
@TypeConverters(Converter::class)

abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    companion object {
        @Volatile
        private var instance: ArticleDatabase? = null


        operator fun invoke(context: Context) = instance ?: synchronized(this){
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article-db.db"
            ).build()
    }
}