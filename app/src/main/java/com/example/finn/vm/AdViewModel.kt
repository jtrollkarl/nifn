package com.example.finn.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.finn.AdRepo
import com.example.finn.data.DiscoverResult
import com.example.finn.data.Item
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AdViewModel @Inject constructor(private val repo: AdRepo) : ViewModel() {

    val resultLiveData: LiveData<DiscoverResult> = repo.repoResultLiveData

    fun refreshAds() {
        repo.refreshAdsFromWeb()
    }

    fun saveFavourite(item: Item) {
        repo.saveFavouriteToDb(item)
    }
}