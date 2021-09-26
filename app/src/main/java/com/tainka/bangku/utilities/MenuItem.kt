package com.tainka.bangku.utilities

import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.tainka.bangku.R
import com.tainka.bangku.data.MenuItemData
import com.tainka.bangku.fragment.FragmentEncryptionKeyPage
import com.tainka.bangku.fragment.FragmentFileListPage
import com.tainka.bangku.fragment.FragmentFileListPageDirections

object MenuItem {
    fun getMenuItem(fragment : FragmentFileListPage) : ArrayList<MenuItemData>
    {
        val returnValue = ArrayList<MenuItemData>()

        returnValue.add(
            MenuItemData(R.string.itemMenu0, R.drawable.ic_key) {
                val action = FragmentFileListPageDirections.actionFragmentFileListPageToFragmentEncryptionKeyPage2(fragment)
                fragment.findNavController().navigate(action)
            }
        )
        returnValue.add(
            MenuItemData(R.string.itemMenu1, R.drawable.ic_key) {

            }
        )
        returnValue.add(
            MenuItemData(R.string.itemMenu2, R.drawable.ic_key) {

            }
        )
        returnValue.add(
            MenuItemData(R.string.itemMenu3, R.drawable.ic_key) {

            }
        )
        returnValue.add(
            MenuItemData(R.string.itemMenu4, R.drawable.ic_key) {

            }
        )
        returnValue.add(
            MenuItemData(R.string.itemMenu5, R.drawable.ic_key) {

            }
        )
        returnValue.add(
            MenuItemData(R.string.itemMenu6, R.drawable.ic_key) {

            }
        )

        return returnValue
    }
}