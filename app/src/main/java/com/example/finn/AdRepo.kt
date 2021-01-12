package com.example.finn

import androidx.lifecycle.MutableLiveData
import com.example.finn.data.Item
import com.example.finn.room.AppDatabase
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import timber.log.Timber
import javax.inject.Inject

class AdRepo @Inject constructor(
    private val api: DiscoverApi,
    private val db: AppDatabase,
    private val schedulers: Schedulers
) {

    private val liveDataMutable = MutableLiveData<List<Item>>()
    val repoLiveData = liveDataMutable

    init {
        pushAdsFromWeb()
    }

    fun saveItem(item: Item) {
        Flowable.fromCallable { db.itemDao().checkItemExists(item.id) }
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .flatMap { list ->
                if (list.isEmpty()) {
                    Timber.d("item id ${item.id} did not exist. inserting...")
                    return@flatMap Flowable.fromCallable { db.itemDao().insert(item) }
                        .subscribeOn(schedulers.io()).observeOn(schedulers.ui())
                } else {
                    Timber.d("item id ${item.id} exists. removing...")
                    return@flatMap Flowable.fromCallable { db.itemDao().delete(item) }
                        .subscribeOn(schedulers.io()).observeOn(schedulers.ui())
                }
            }.subscribe(
                { Timber.d("Success") },
                { e -> Timber.e(e) }
            )
    }

    fun deleteItem(item: Item) {
        Single.just(item)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.io())
            .subscribe(
                { db.itemDao().delete(item) },
                { e -> Timber.e(e) }
            )
    }

    fun pushFavourites() {
        db.itemDao().getItemsFlowable()
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .subscribe(
                { items -> repoLiveData.value = items },
                { e -> Timber.e(e) })
    }

    fun pushAdsMinusFavourites() {
        db.itemDao().getItemsFlowable().zipWith(api.fetchAds()) { dbItems, webItems ->
            webItems.items?.minus(dbItems)
        }
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .subscribe(
                { result -> liveDataMutable.value = result },
                { e -> Timber.e(e) }
            )

    }

    fun pushAdsFromWeb() {
        api.fetchAds()
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .subscribe(
                { items -> liveDataMutable.value = items?.items },
                { e -> Timber.e(e) }
            )
    }
}