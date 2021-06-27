package com.web0z.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.web0z.data.local.dao.ArticlesDao
import com.web0z.data.local.entity.ArticleEntity

@Database(
    entities = [ArticleEntity::class],
    version = 1
)
abstract class CoffeeTimeNewsDatabase : RoomDatabase() {

    abstract fun getArticlesDao(): ArticlesDao

    companion object {
        private const val DB_NAME = "article_database"

        @Volatile
        private var INSTANCE: CoffeeTimeNewsDatabase? = null

        fun getInstance(context: Context): CoffeeTimeNewsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CoffeeTimeNewsDatabase::class.java,
                    DB_NAME
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}