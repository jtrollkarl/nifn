package com.example.finn

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import com.example.finn.data.DiscoverResult
import com.example.finn.data.Item
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class AdRepo @Inject constructor(
    private val api: DiscoverApi
) {

    var repoResultLiveData: LiveData<DiscoverResult> =
        LiveDataReactiveStreams.fromPublisher(api.fetchAds())
        private set


    fun saveFavouriteToDb(item: Item) {

    }

    fun refreshAdsFromWeb() {
        repoResultLiveData = LiveDataReactiveStreams.fromPublisher(api.fetchAds())
    }
}