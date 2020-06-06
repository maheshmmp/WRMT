package com.example.whiterabbitct.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
* Created by Aleksandr Nikiforov on 8/1/17.
*/
@Dao
interface RabbitDao {

    /**
     * Get locations LiveData.
     * Can be called from the main thread.
     * @return LiveData of GroLocation list.
     */
    @Query("SELECT * FROM rabbit")
    fun getRabbitsLiveData(): LiveData<List<Rabbit>>

    /**
     * Get locations list.
     * Can be called from the main thread.
     * @return List of GroLocation objects.
     */
    @Query("SELECT * FROM rabbit")
    fun getAllRabbits(): List<Rabbit>

    /**
     * Insert new locations.
     * Have to ba called in background thread.
     * @param location GeoLocation object.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg location: Rabbit)


}