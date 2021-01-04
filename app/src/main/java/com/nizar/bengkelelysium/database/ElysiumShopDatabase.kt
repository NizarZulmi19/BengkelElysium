package com.nizar.bengkelelysium.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ElysiumShop::class], version = 1, exportSchema = false)
abstract class ElysiumShopDatabase : RoomDatabase() {

    abstract val elysiumShopDAO: ElysiumShopDAO

    companion object {
        @Volatile
        private var INSTANCE: ElysiumShopDatabase? = null

        fun getInstance(context: Context) : ElysiumShopDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            ElysiumShopDatabase::class.java,
                            "elysium_database"
                        )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}