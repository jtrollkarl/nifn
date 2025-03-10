package com.example.finn.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finn.App
import com.example.finn.R
import com.example.finn.di.VmFactory
import com.example.finn.vm.AdViewModel
import kotlinx.android.synthetic.main.fragment_ad_list.*
import javax.inject.Inject

class AdListFragment : Fragment() {

    @Inject
    lateinit var vmFactory: VmFactory

    private lateinit var viewModel: AdViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_ad_list, container, false)

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment_ad_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.refresh_web -> {
                viewModel.refreshAds()
                return true
            }
            R.id.show_favourites -> {
                viewModel.showFavourites()
                return true
            }
            R.id.show_minus_favourites -> {
                viewModel.showAdsWithoutFavourites()
                return true
            }
            else -> return false
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.getApp(requireContext()).daggerAppComponent.inject(this)

        val itemRecyclerAdapter =
            AdItemRecyclerAdapter(emptyList()) { item -> viewModel.saveFavourite(item) }
        recycler_ads.run {
            val lm = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            val decoration = DividerItemDecoration(context, lm.orientation)
            this.layoutManager = lm
            this.adapter = itemRecyclerAdapter
            this.addItemDecoration(decoration)
        }

        viewModel = ViewModelProvider(requireActivity(), vmFactory)[AdViewModel::class.java]
        viewModel.resultLiveData.observe(viewLifecycleOwner, {
            it.let { items ->
                itemRecyclerAdapter.setData(items)
                itemRecyclerAdapter.notifyDataSetChanged()
            }
        })

    }
}