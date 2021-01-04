package com.nizar.bengkelelysium.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import java.sql.RowId

@Dao
interface ElysiumShopDAO {

    @Insert
    fun insert(elysiumShop: ElysiumShop)

    @Update
    fun update(elysiumShop: ElysiumShop)

    @Query("SELECT * FROM elysiumshop")
    fun getElysiumShop(): LiveData<List<ElysiumShop>>

    @Query("DELETE FROM elysiumshop")
    fun clear()

    @Query("DELETE FROM elysiumshop WHERE id = :elysiumShopId")
    fun delete(elysiumShopId : Long)

}