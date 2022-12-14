package com.techands.roomcompose.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    companion object {

        @Volatile
        private var instance: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase =
            instance ?: synchronized(this){
                instance ?: buildDatabase(context)
                    .also{
                        instance = it
                    }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                UserDatabase::class.java,
                "UserDB"
            ).allowMainThreadQueries()
                .build()
    }

}