package com.tainka.bangku.utilities

import android.view.Menu
import androidx.core.content.ContextCompat
import com.tainka.bangku.R
import com.tainka.bangku.data.MenuItemData

object MenuItem {
    fun getMenuItem() : ArrayList<MenuItemData>
    {
        val returnValue = ArrayList<MenuItemData>()

        returnValue.add(
            MenuItemData("Key", R.drawable.ic_key) {

            }
        )

        return returnValue
    }
}