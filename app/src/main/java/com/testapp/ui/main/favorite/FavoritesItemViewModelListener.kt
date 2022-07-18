package com.testapp.ui.main.favorite

import com.testapp.domain.db.Article
import com.testapp.ui.base.BaseItemListener

interface FavoritesItemViewModelListener : BaseItemListener<Article> {
    override fun onRetryClick() {}
}