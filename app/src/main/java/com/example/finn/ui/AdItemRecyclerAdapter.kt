package com.example.finn.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finn.R
import com.example.finn.data.Item
import kotlinx.android.synthetic.main.list_item_ad_item.view.*
import timber.log.Timber

class AdItemRecyclerAdapter(private var list: List<Item>, private val onFavClick: (Item) -> Unit) :
    RecyclerView.Adapter<AdItemRecyclerAdapter.AdItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item_ad_item, parent, false)
        return AdItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdItemViewHolder, position: Int) =
        holder.bind(list[position], onFavClick)


    override fun getItemCount(): Int = list.size

    fun setData(adList: List<Item>) {
        list = adList
    }

    class AdItemViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        fun bind(item: Item, onFavClick: (Item) -> Unit) {
            itemView.tv_ad_location.text = item.location
            itemView.tv_ad_price.text =
                itemView.context.getString(R.string.price_kr, item.price?.value)
            itemView.tv_ad_title.text = item.description
            Timber.d("https://images.finncdn.no/dynamic/480x360c/${item.image?.url}")
            Glide.with(itemView).load("https://images.finncdn.no/dynamic/480x360c/${item.image?.url}").into(itemView.iv_ad_image)

            itemView.iv_favourite.setOnClickListener { onFavClick(item) }
        }
    }
}