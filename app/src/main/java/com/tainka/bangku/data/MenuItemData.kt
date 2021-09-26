package com.tainka.bangku.data

/**
 * @param logoResource : ID of logo from drawable
 * @param execute : function that will be executed on click of item
 */
data class MenuItemData(var text : Int, var logoResource : Int, var execute : () -> Unit) {}
