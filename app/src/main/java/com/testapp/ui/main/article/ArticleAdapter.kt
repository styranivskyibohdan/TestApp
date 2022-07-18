package com.testapp.ui.main.article

import android.view.LayoutInflater
import android.view.ViewGroup
import com.testapp.databinding.ItemArticleEmptyViewBinding
import com.testapp.databinding.ItemArticleViewBinding
import com.testapp.ui.base.BaseRecyclerViewAdapter
import com.testapp.ui.base.BaseViewHolder
import com.testapp.utils.AppConstants.VIEW_TYPE_EMPTY
import com.testapp.utils.AppConstants.VIEW_TYPE_NORMAL

class ArticleAdapter(items: MutableList<ArticleDataItem>, listener: ArticleAdapterListener) :
    BaseRecyclerViewAdapter<ArticleDataItem>(items, listener) {

    override fun getItemCount(): Int {
        return if (items.size > 0) items.size else 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (items.isNotEmpty()) VIEW_TYPE_NORMAL else VIEW_TYPE_EMPTY
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            VIEW_TYPE_NORMAL -> {
                ArticleViewHolder(
                    ItemArticleViewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent, false
                    )
                )
            }
            else -> {
                EmptyViewHolder(
                    ItemArticleEmptyViewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent, false
                    )
                )
            }
        }
    }

    inner class ArticleViewHolder(private val mBinding: ItemArticleViewBinding) :
        BaseViewHolder(mBinding.root) {
        override fun onBind(position: Int) {
            val articleDataItem = items[position]
            mBinding.articleDataItem = articleDataItem
            mBinding.item = ArticleItemView { itemListener.onItemClick(articleDataItem) }
            mBinding.executePendingBindings()
        }
    }

    inner class EmptyViewHolder(private val mBinding: ItemArticleEmptyViewBinding) :
        BaseViewHolder(mBinding.root) {
        override fun onBind(position: Int) {
            mBinding.item = ArticleEmptyItemView { itemListener.onRetryClick() }
            mBinding.executePendingBindings()
        }
    }
}