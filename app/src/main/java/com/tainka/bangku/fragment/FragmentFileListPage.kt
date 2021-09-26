package com.tainka.bangku.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tainka.bangku.adapter.ItemMenuAdapter
import com.tainka.bangku.databinding.FragmentFileListPageBinding
import com.tainka.bangku.utilities.MenuItem

class FragmentFileListPage : Fragment() {
    lateinit var binding : FragmentFileListPageBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFileListPageBinding.inflate(inflater, container, false)


        val menuItemAdapter = ItemMenuAdapter()
        binding.itemMenuList.apply {
            adapter = menuItemAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        menuItemAdapter.setItemList(MenuItem.getMenuItem())

        return binding.root
    }
}