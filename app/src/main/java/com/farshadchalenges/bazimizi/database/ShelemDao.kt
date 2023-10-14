package com.farshadchalenges.bazimizi.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

//Data Access Object
//here we will define all functions we need to do with our table
@Dao
interface ShelemDao {

    @Upsert
    suspend fun upsertNewGame(shelem: Shelem)

    @Delete
    suspend fun deleteShelem(shelem: Shelem)

    @Query("SELECT * FROM shelem ORDER BY id ASC")
    fun getShelemHandsOrderedByID(): Flow<List<Shelem>>
}