package com.testapp.ui.main.favorite

class FavoritesItemView(private val action: () -> Unit) {
    fun onItemClick() = action.invoke()
}