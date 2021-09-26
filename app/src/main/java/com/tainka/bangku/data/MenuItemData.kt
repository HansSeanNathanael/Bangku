package com.tainka.bangku.data

/**
 * @logoResource : ID of logo from drawable
 * @execute : function that will be executed on click of item
 */
data class MenuItemData(var text : String, var logoResource : Int, var execute : () -> Unit) {}
