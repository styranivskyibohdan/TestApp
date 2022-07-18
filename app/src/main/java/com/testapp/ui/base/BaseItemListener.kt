package com.testapp.ui.base

interface BaseItemListener<T> {
    fun onItemClick(item: T)
    fun onRetryClick()
}