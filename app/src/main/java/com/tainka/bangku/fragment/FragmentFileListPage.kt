package com.tainka.bangku.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tainka.bangku.MainActivity
import com.tainka.bangku.adapter.ItemMenuAdapter
import com.tainka.bangku.databinding.FragmentFileListPageBinding
import com.tainka.bangku.utilities.MenuItem
import java.io.Serializable

class FragmentFileListPage : Fragment(), Serializable {
    private lateinit var binding : FragmentFileListPageBinding
    private var encryptionKey : String? = null

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

        menuItemAdapter.setItemList(MenuItem.getMenuItem(this))
        Log.d("Tes", encryptionKey ?: "No Key!")
        return binding.root
    }

    fun setNewKey(newKey : String?)
    {
        encryptionKey = newKey
    }
}