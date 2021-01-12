package com.example.finn.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.finn.AdRepo
import com.example.finn.data.Item
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AdViewModel @Inject constructor(private val repo: AdRepo) : ViewModel() {

    val resultLiveData: LiveData<List<Item>> = repo.repoLiveData

    fun refreshAds() {
        repo.pushAdsFromWeb()
    }

    fun showFavourites() {
        repo.pushFavourites()
    }

    fun showAdsWithoutFavourites() {
        repo.pushAdsMinusFavourites()
    }

    fun removeFavourite(item: Item){
        repo.deleteItem(item)
    }

    fun saveFavourite(item: Item) {
        repo.saveItem(item)
    }
}