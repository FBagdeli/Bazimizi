package com.farshadchalenges.bazimizi.database

import androidx.room.Database
import androidx.room.RoomDatabase
//here we define our Database and what is entities and define our dao
@Database(
    entities = [Shelem::class],
    version = 1
)
abstract class ShelemDatabase: RoomDatabase() {
    abstract val dao: ShelemDao
}