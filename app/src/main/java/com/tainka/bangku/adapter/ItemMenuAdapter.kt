package com.tainka.bangku.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.tainka.bangku.R
import com.tainka.bangku.data.MenuItemData
import com.tainka.bangku.databinding.ItemMenuBinding

class ItemMenuAdapter : RecyclerView.Adapter<ItemMenuAdapter.ItemMenuViewHolder>() {
    private val itemList : ArrayList<MenuItemData> = ArrayList()

    inner class ItemMenuViewHolder(private val binding : ItemMenuBinding) : RecyclerView.ViewHolder(binding.root)
    {
        /**
         * @param itemMenuData : data about item menu (logo, title, and function when clicked)
         */
        fun bind(itemMenuData : MenuItemData)
        {
            binding.menuItemImage.setImageResource(itemMenuData.logoResource)
            binding.itemMenuTitle.setText(itemMenuData.text)

            binding.root.setOnClickListener {
                itemMenuData.execute.invoke()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemMenuViewHolder {
        val binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context))
        return ItemMenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemMenuViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    /**
     * @param newList : new list of item menu
     */
    fun setItemList(newList : ArrayList<MenuItemData>)
    {
        itemList.clear()
        itemList.addAll(newList)

        notifyDataSetChanged()
    }

}