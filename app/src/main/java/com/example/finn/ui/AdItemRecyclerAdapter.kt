package com.example.finn.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finn.R
import com.example.finn.data.Item

class AdItemRecyclerAdapter(private var list: List<Item>, onFavClick: (Item) -> Unit) :
    RecyclerView.Adapter<AdItemRecyclerAdapter.AdItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item_ad_item, parent, false)
        return AdItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setDate(adList: List<Item>) {
        list = adList
    }

    class AdItemViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        fun bind(item: Item) {
            TODO("bind view w data and stuff")
        }

    }

}