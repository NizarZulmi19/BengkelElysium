package com.nizar.bengkelelysium.ui.home

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.*
import com.nizar.bengkelelysium.database.ElysiumShop
import com.nizar.bengkelelysium.database.ElysiumShopDAO

class ElysiumShopViewModel(
    val database: ElysiumShopDAO,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope =   CoroutineScope(Dispatchers.Main + viewModelJob)
    val elysiumShop = database.getElysiumShop()

    fun onClickInsert(elysiumShop: ElysiumShop) {
        uiScope.launch {
            insert(elysiumShop)
        }
    }

    private suspend fun insert(elysiumShop: ElysiumShop) {
        withContext(Dispatchers.IO) {
            database.insert(elysiumShop)
        }
    }

    fun onClickUpdate(elysiumShop: ElysiumShop) {
        uiScope.launch {
            update(elysiumShop)
        }
    }

    private suspend fun update(elysiumShop: ElysiumShop) {
        withContext(Dispatchers.IO) {
            database.update(elysiumShop)
        }
    }

    fun onClickClear() {
        uiScope.launch {
            clear()
        }
    }

    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }

    fun onClickDelete(id: Long) {
        uiScope.launch {
            delete(id)
        }
    }

    private suspend fun delete(id: Long) {
        withContext(Dispatchers.IO) {
            database.delete(id)
        }
    }

    @Suppress("UNCHECKED_CAST")
    class Factory (
        private val dataSource: ElysiumShopDAO,
        private val application: Application
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {

            if (modelClass.isAssignableFrom(ElysiumShopViewModel::class.java)) {
                return ElysiumShopViewModel(
                    dataSource,
                    application
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")

        }

    }
}